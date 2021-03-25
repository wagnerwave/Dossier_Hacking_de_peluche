package androidx.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplBase implements AudioAttributesImpl {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mContentType = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mFlags = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mLegacyStream = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mUsage = 0;

    public static class Builder implements AudioAttributesImpl.Builder {
        public int mContentType = 0;
        public int mFlags = 0;
        public int mLegacyStream = -1;
        public int mUsage = 0;

        public Builder() {
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            this.mUsage = audioAttributesCompat.getUsage();
            this.mContentType = audioAttributesCompat.getContentType();
            this.mFlags = audioAttributesCompat.getFlags();
            this.mLegacyStream = audioAttributesCompat.getRawLegacyStreamType();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0031, code lost:
            r3.mContentType = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
            r3.mContentType = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
            r3.mUsage = androidx.media.AudioAttributesImplBase.usageForStreamType(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
            return r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private androidx.media.AudioAttributesImplBase.Builder setInternalLegacyStreamType(int r4) {
            /*
                r3 = this;
                r0 = 1
                r1 = 4
                switch(r4) {
                    case 0: goto L_0x0034;
                    case 1: goto L_0x0031;
                    case 2: goto L_0x0031;
                    case 3: goto L_0x002f;
                    case 4: goto L_0x0031;
                    case 5: goto L_0x0031;
                    case 6: goto L_0x0027;
                    case 7: goto L_0x0021;
                    case 8: goto L_0x0031;
                    case 9: goto L_0x0031;
                    case 10: goto L_0x0034;
                    default: goto L_0x0005;
                }
            L_0x0005:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Invalid stream type "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " for AudioAttributesCompat"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "AudioAttributesCompat"
                android.util.Log.e(r1, r0)
                goto L_0x0036
            L_0x0021:
                int r2 = r3.mFlags
                r0 = r0 | r2
                r3.mFlags = r0
                goto L_0x0031
            L_0x0027:
                r3.mContentType = r0
                int r0 = r3.mFlags
                r0 = r0 | r1
                r3.mFlags = r0
                goto L_0x0036
            L_0x002f:
                r0 = 2
                goto L_0x0034
            L_0x0031:
                r3.mContentType = r1
                goto L_0x0036
            L_0x0034:
                r3.mContentType = r0
            L_0x0036:
                int r4 = androidx.media.AudioAttributesImplBase.usageForStreamType(r4)
                r3.mUsage = r4
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media.AudioAttributesImplBase.Builder.setInternalLegacyStreamType(int):androidx.media.AudioAttributesImplBase$Builder");
        }

        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
        }

        @NonNull
        public Builder setContentType(int i) {
            if (!(i == 0 || i == 1 || i == 2 || i == 3 || i == 4)) {
                i = 0;
            }
            this.mContentType = i;
            return this;
        }

        @NonNull
        public Builder setFlags(int i) {
            this.mFlags = (i & AudioAttributesCompat.FLAG_ALL) | this.mFlags;
            return this;
        }

        @NonNull
        public Builder setLegacyStreamType(int i) {
            if (i != 10) {
                this.mLegacyStream = i;
                return setInternalLegacyStreamType(i);
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        @NonNull
        public Builder setUsage(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                case 16:
                    i = 12;
                    break;
                default:
                    i = 0;
                    break;
            }
            this.mUsage = i;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplBase() {
    }

    public AudioAttributesImplBase(int i, int i2, int i3, int i4) {
        this.mContentType = i;
        this.mFlags = i2;
        this.mUsage = i3;
        this.mLegacyStream = i4;
    }

    public static int usageForStreamType(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 10:
                return 11;
            default:
                return 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.mContentType == audioAttributesImplBase.getContentType() && this.mFlags == audioAttributesImplBase.getFlags() && this.mUsage == audioAttributesImplBase.getUsage() && this.mLegacyStream == audioAttributesImplBase.mLegacyStream;
    }

    @Nullable
    public Object getAudioAttributes() {
        return null;
    }

    public int getContentType() {
        return this.mContentType;
    }

    public int getFlags() {
        int i = this.mFlags;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i |= 4;
        } else if (legacyStreamType == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int getLegacyStreamType() {
        int i = this.mLegacyStream;
        return i != -1 ? i : AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage);
    }

    public int getRawLegacyStreamType() {
        return this.mLegacyStream;
    }

    public int getUsage() {
        return this.mUsage;
    }

    public int getVolumeControlStream() {
        return AudioAttributesCompat.toVolumeStreamType(true, this.mFlags, this.mUsage);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream)});
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream != -1) {
            sb.append(" stream=");
            sb.append(this.mLegacyStream);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.usageToString(this.mUsage));
        sb.append(" content=");
        sb.append(this.mContentType);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.mFlags).toUpperCase());
        return sb.toString();
    }
}
