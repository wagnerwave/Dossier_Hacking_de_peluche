package okhttp3;

import a.a.a.a.a;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    public final CertificateChainCleaner certificateChainCleaner;
    public final Set<Pin> pins;

    public static final class Builder {
        public final List<Pin> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            if (str != null) {
                for (String pin : strArr) {
                    this.pins.add(new Pin(str, pin));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), (CertificateChainCleaner) null);
        }
    }

    public static final class Pin {
        public static final String WILDCARD = "*.";
        public final String canonicalHostname;
        public final ByteString hash;
        public final String hashAlgorithm;
        public final String pattern;

        public Pin(String str, String str2) {
            StringBuilder sb;
            int i;
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                sb = a.n("http://");
                str = str.substring(2);
            } else {
                sb = a.n("http://");
            }
            sb.append(str);
            this.canonicalHostname = HttpUrl.parse(sb.toString()).host();
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                i = 5;
            } else if (str2.startsWith("sha256/")) {
                this.hashAlgorithm = "sha256/";
                i = 7;
            } else {
                throw new IllegalArgumentException(a.k("pins must start with 'sha256/' or 'sha1/': ", str2));
            }
            this.hash = ByteString.decodeBase64(str2.substring(i));
            if (this.hash == null) {
                throw new IllegalArgumentException(a.k("pins must be base64: ", str2));
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                return this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash);
            }
        }

        public int hashCode() {
            int hashCode = this.hashAlgorithm.hashCode();
            return this.hash.hashCode() + ((hashCode + ((this.pattern.hashCode() + 527) * 31)) * 31);
        }

        public boolean matches(String str) {
            if (!this.pattern.startsWith(WILDCARD)) {
                return str.equals(this.canonicalHostname);
            }
            String str2 = this.canonicalHostname;
            return str.regionMatches(false, str.indexOf(46) + 1, str2, 0, str2.length());
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner2) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder n = a.n("sha256/");
            n.append(sha256((X509Certificate) certificate).base64());
            return n.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static ByteString sha1(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    public static ByteString sha256(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void check(String str, List<Certificate> list) {
        List<Pin> findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
            if (certificateChainCleaner2 != null) {
                list = certificateChainCleaner2.clean(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = findMatchingPins.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    Pin pin = findMatchingPins.get(i2);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = sha256(x509Certificate);
                        }
                        if (pin.hash.equals(byteString)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = sha1(x509Certificate);
                        }
                        if (pin.hash.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder p = a.p("Certificate pinning failure!", "\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                p.append("\n    ");
                p.append(pin(x509Certificate2));
                p.append(": ");
                p.append(x509Certificate2.getSubjectDN().getName());
            }
            p.append("\n  Pinned certificates for ");
            p.append(str);
            p.append(":");
            int size4 = findMatchingPins.size();
            for (int i4 = 0; i4 < size4; i4++) {
                p.append("\n    ");
                p.append(findMatchingPins.get(i4));
            }
            throw new SSLPeerUnverifiedException(p.toString());
        }
    }

    public void check(String str, Certificate... certificateArr) {
        check(str, (List<Certificate>) Arrays.asList(certificateArr));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            return Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins);
        }
    }

    public List<Pin> findMatchingPins(String str) {
        List<Pin> emptyList = Collections.emptyList();
        for (Pin next : this.pins) {
            if (next.matches(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        return this.pins.hashCode() + ((certificateChainCleaner2 != null ? certificateChainCleaner2.hashCode() : 0) * 31);
    }

    public CertificatePinner withCertificateChainCleaner(CertificateChainCleaner certificateChainCleaner2) {
        return Util.equal(this.certificateChainCleaner, certificateChainCleaner2) ? this : new CertificatePinner(this.pins, certificateChainCleaner2);
    }
}
