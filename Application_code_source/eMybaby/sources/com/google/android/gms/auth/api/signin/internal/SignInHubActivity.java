package com.google.android.gms.auth.api.signin.internal;

import a.d.a.a.c.a.d.c.e;
import a.d.a.a.c.a.d.c.l;
import a.d.a.a.c.a.d.c.t;
import a.d.a.a.e.k.d;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.tuya.smart.android.network.http.BusinessResponse;
import java.util.Set;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    public static boolean f = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4184a = false;

    /* renamed from: b  reason: collision with root package name */
    public SignInConfiguration f4185b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4186c;

    /* renamed from: d  reason: collision with root package name */
    public int f4187d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f4188e;

    public class a implements LoaderManager.LoaderCallbacks<Void> {
        public a(t tVar) {
        }

        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            Set<d> set;
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            synchronized (d.f1263a) {
                set = d.f1263a;
            }
            return new e(signInHubActivity, set);
        }

        public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            Void voidR = (Void) obj;
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f4187d, signInHubActivity.f4188e);
            SignInHubActivity.this.finish();
        }

        public final void onLoaderReset(Loader<Void> loader) {
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final void o(int i) {
        Status status = new Status(1, i, (String) null, (PendingIntent) null);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f = false;
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        GoogleSignInAccount googleSignInAccount;
        if (!this.f4184a) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && (googleSignInAccount = signInAccount.f4177b) != null) {
                        l b2 = l.b(this);
                        GoogleSignInOptions googleSignInOptions = this.f4185b.f4183b;
                        synchronized (b2) {
                            b2.f1221a.d(googleSignInAccount, googleSignInOptions);
                        }
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", googleSignInAccount);
                        this.f4186c = true;
                        this.f4187d = i2;
                        this.f4188e = intent;
                        getSupportLoaderManager().initLoader(0, (Bundle) null, new a((t) null));
                        f = false;
                        return;
                    } else if (intent.hasExtra(BusinessResponse.KEY_ERRCODE)) {
                        int intExtra = intent.getIntExtra(BusinessResponse.KEY_ERRCODE, 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        o(intExtra);
                        return;
                    }
                }
                o(8);
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        a.c.a.d.a.d(action);
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            o(12500);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Bundle bundleExtra = intent.getBundleExtra("config");
            a.c.a.d.a.d(bundleExtra);
            SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
            if (signInConfiguration == null) {
                Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                setResult(0);
                finish();
                return;
            }
            this.f4185b = signInConfiguration;
            if (bundle != null) {
                boolean z = bundle.getBoolean("signingInGoogleApiClients");
                this.f4186c = z;
                if (z) {
                    this.f4187d = bundle.getInt("signInResultCode");
                    Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                    a.c.a.d.a.d(intent2);
                    this.f4188e = intent2;
                    getSupportLoaderManager().initLoader(0, (Bundle) null, new a((t) null));
                    f = false;
                }
            } else if (f) {
                setResult(0);
                o(12502);
            } else {
                f = true;
                Intent intent3 = new Intent(action);
                intent3.setPackage(action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") ? "com.google.android.gms" : getPackageName());
                intent3.putExtra("config", this.f4185b);
                try {
                    startActivityForResult(intent3, 40962);
                } catch (ActivityNotFoundException unused) {
                    this.f4184a = true;
                    Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                    o(17);
                }
            }
        } else {
            String valueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            finish();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f4186c);
        if (this.f4186c) {
            bundle.putInt("signInResultCode", this.f4187d);
            bundle.putParcelable("signInResultData", this.f4188e);
        }
    }
}
