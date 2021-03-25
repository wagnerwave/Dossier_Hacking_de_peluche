package androidx.transition;

import a.a.a.a.a;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    @Deprecated
    public TransitionValues() {
    }

    public TransitionValues(@NonNull View view2) {
        this.view = view2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder n = a.n("TransitionValues@");
        n.append(Integer.toHexString(hashCode()));
        n.append(":\n");
        StringBuilder p = a.p(n.toString(), "    view = ");
        p.append(this.view);
        p.append("\n");
        String k = a.k(p.toString(), "    values:");
        for (String next : this.values.keySet()) {
            k = k + "    " + next + ": " + this.values.get(next) + "\n";
        }
        return k;
    }
}
