package androidx.core.app;

import a.a.a.a.a;
import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    public static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    public static final String TAG = "RemoteInput";
    public final boolean mAllowFreeFormTextInput;
    public final Set<String> mAllowedDataTypes;
    public final CharSequence[] mChoices;
    public final int mEditChoicesBeforeSending;
    public final Bundle mExtras;
    public final CharSequence mLabel;
    public final String mResultKey;

    public static final class Builder {
        public boolean mAllowFreeFormTextInput = true;
        public final Set<String> mAllowedDataTypes = new HashSet();
        public CharSequence[] mChoices;
        public int mEditChoicesBeforeSending = 0;
        public final Bundle mExtras = new Bundle();
        public CharSequence mLabel;
        public final String mResultKey;

        public Builder(@NonNull String str) {
            if (str != null) {
                this.mResultKey = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        @NonNull
        public Builder addExtras(@NonNull Bundle bundle) {
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            return this;
        }

        @NonNull
        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }

        @NonNull
        public Bundle getExtras() {
            return this.mExtras;
        }

        @NonNull
        public Builder setAllowDataType(@NonNull String str, boolean z) {
            if (z) {
                this.mAllowedDataTypes.add(str);
            } else {
                this.mAllowedDataTypes.remove(str);
            }
            return this;
        }

        @NonNull
        public Builder setAllowFreeFormInput(boolean z) {
            this.mAllowFreeFormTextInput = z;
            return this;
        }

        @NonNull
        public Builder setChoices(@Nullable CharSequence[] charSequenceArr) {
            this.mChoices = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder setEditChoicesBeforeSending(int i) {
            this.mEditChoicesBeforeSending = i;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable CharSequence charSequence) {
            this.mLabel = charSequence;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    public RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i, Bundle bundle, Set<String> set) {
        this.mResultKey = str;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArr;
        this.mAllowFreeFormTextInput = z;
        this.mEditChoicesBeforeSending = i;
        this.mExtras = bundle;
        this.mAllowedDataTypes = set;
        if (getEditChoicesBeforeSending() == 2 && !getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        if (Build.VERSION.SDK_INT >= 26) {
            android.app.RemoteInput.addDataResultToIntent(fromCompat(remoteInput), intent, map);
            return;
        }
        Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            clipDataIntentFromIntent = new Intent();
        }
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Uri uri = (Uri) next.getValue();
            if (str != null) {
                Bundle bundleExtra = clipDataIntentFromIntent.getBundleExtra(getExtraResultsKeyForData(str));
                if (bundleExtra == null) {
                    bundleExtra = new Bundle();
                }
                bundleExtra.putString(remoteInput.getResultKey(), uri.toString());
                clipDataIntentFromIntent.putExtra(getExtraResultsKeyForData(str), bundleExtra);
            }
        }
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            android.app.RemoteInput.addResultsToIntent(fromCompat(remoteInputArr), intent, bundle);
            return;
        }
        if (i >= 20) {
            Bundle resultsFromIntent = getResultsFromIntent(intent);
            int resultsSource = getResultsSource(intent);
            if (resultsFromIntent != null) {
                resultsFromIntent.putAll(bundle);
                bundle = resultsFromIntent;
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                Map<String, Uri> dataResultsFromIntent = getDataResultsFromIntent(intent, remoteInput.getResultKey());
                android.app.RemoteInput.addResultsToIntent(fromCompat(new RemoteInput[]{remoteInput}), intent, bundle);
                if (dataResultsFromIntent != null) {
                    addDataResultToIntent(remoteInput, intent, dataResultsFromIntent);
                }
            }
            setResultsSource(intent, resultsSource);
            return;
        }
        Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            clipDataIntentFromIntent = new Intent();
        }
        Bundle bundleExtra = clipDataIntentFromIntent.getBundleExtra(EXTRA_RESULTS_DATA);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        for (RemoteInput remoteInput2 : remoteInputArr) {
            Object obj = bundle.get(remoteInput2.getResultKey());
            if (obj instanceof CharSequence) {
                bundleExtra.putCharSequence(remoteInput2.getResultKey(), (CharSequence) obj);
            }
        }
        clipDataIntentFromIntent.putExtra(EXTRA_RESULTS_DATA, bundleExtra);
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
    }

    @RequiresApi(20)
    public static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
        }
        return addExtras.build();
    }

    @RequiresApi(20)
    public static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = fromCompat(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    @RequiresApi(16)
    public static Intent getClipDataIntentFromIntent(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL)) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
        String string;
        if (Build.VERSION.SDK_INT >= 26) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }
        Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : clipDataIntentFromIntent.getExtras().keySet()) {
            if (str2.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA)) {
                String substring = str2.substring(39);
                if (!substring.isEmpty() && (string = clipDataIntentFromIntent.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                    hashMap.put(substring, Uri.parse(string));
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public static String getExtraResultsKeyForData(String str) {
        return a.k(EXTRA_DATA_TYPE_RESULTS_DATA, str);
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        if (Build.VERSION.SDK_INT >= 20) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
        Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            return null;
        }
        return (Bundle) clipDataIntentFromIntent.getExtras().getParcelable(EXTRA_RESULTS_DATA);
    }

    public static int getResultsSource(@NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return android.app.RemoteInput.getResultsSource(intent);
        }
        Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            return 0;
        }
        return clipDataIntentFromIntent.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
    }

    public static void setResultsSource(@NonNull Intent intent, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            android.app.RemoteInput.setResultsSource(intent, i);
            return;
        }
        Intent clipDataIntentFromIntent = getClipDataIntentFromIntent(intent);
        if (clipDataIntentFromIntent == null) {
            clipDataIntentFromIntent = new Intent();
        }
        clipDataIntentFromIntent.putExtra(EXTRA_RESULTS_SOURCE, i);
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipDataIntentFromIntent));
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public boolean isDataOnly() {
        return !getAllowFreeFormInput() && (getChoices() == null || getChoices().length == 0) && getAllowedDataTypes() != null && !getAllowedDataTypes().isEmpty();
    }
}
