package com.tuya.spongycastle;

import a.a.a.a.a;
import com.tuya.spongycastle.util.Strings;

public class LICENSE {
    public static String licenseText;

    static {
        StringBuilder n = a.n("Copyright (c) 2000-2017 The Legion of the Bouncy Castle Inc. (http://www.bouncycastle.org) ");
        n.append(Strings.lineSeparator());
        n.append(Strings.lineSeparator());
        n.append("Permission is hereby granted, free of charge, to any person obtaining a copy of this software ");
        n.append(Strings.lineSeparator());
        n.append("and associated documentation files (the \"Software\"), to deal in the Software without restriction, ");
        n.append(Strings.lineSeparator());
        n.append("including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, ");
        n.append(Strings.lineSeparator());
        n.append("and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,");
        n.append(Strings.lineSeparator());
        n.append("subject to the following conditions:");
        n.append(Strings.lineSeparator());
        n.append(Strings.lineSeparator());
        n.append("The above copyright notice and this permission notice shall be included in all copies or substantial");
        n.append(Strings.lineSeparator());
        n.append("portions of the Software.");
        n.append(Strings.lineSeparator());
        n.append(Strings.lineSeparator());
        n.append("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,");
        n.append(Strings.lineSeparator());
        n.append("INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR");
        n.append(Strings.lineSeparator());
        n.append("PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE");
        n.append(Strings.lineSeparator());
        n.append("LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR");
        n.append(Strings.lineSeparator());
        n.append("OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER");
        n.append(Strings.lineSeparator());
        n.append("DEALINGS IN THE SOFTWARE.");
        licenseText = n.toString();
    }

    public static void main(String[] strArr) {
        System.out.println(licenseText);
    }
}
