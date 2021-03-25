package d.a.a;

import androidx.core.view.InputDeviceCompat;
import com.tutk.IOTC.AVIOCTRLDEFs;
import java.util.HashMap;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Integer, String> f4832a;

    static {
        HashMap hashMap = new HashMap();
        f4832a = hashMap;
        hashMap.put(0, "Crash Data");
        f4832a.put(1, "The app found information about previous crashes. Would you like to send this data to the developer?");
        f4832a.put(2, "Dismiss");
        f4832a.put(3, "Always send");
        f4832a.put(4, "Send");
        f4832a.put(256, "Download Failed");
        f4832a.put(Integer.valueOf(InputDeviceCompat.SOURCE_KEYBOARD), "The update could not be downloaded. Would you like to try again?");
        f4832a.put(258, "Cancel");
        f4832a.put(259, "Retry");
        f4832a.put(512, "Please install the latest version to continue to use this app.");
        f4832a.put(Integer.valueOf(InputDeviceCompat.SOURCE_DPAD), "Update Available");
        f4832a.put(514, "Show information about the new update?");
        f4832a.put(515, "Dismiss");
        f4832a.put(516, "Show");
        f4832a.put(Integer.valueOf(AVIOCTRLDEFs.IOTYPE_USER_IPCAM_AUDIOSTART), "Build Expired");
        f4832a.put(Integer.valueOf(AVIOCTRLDEFs.IOTYPE_USER_IPCAM_AUDIOSTOP), "This has build has expired. Please check HockeyApp for any updates.");
        f4832a.put(1024, "Feedback Failed");
        f4832a.put(1025, "Would you like to send your feedback again?");
        f4832a.put(Integer.valueOf(AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SET_EVENTCONFIG_REQ), "Name");
        f4832a.put(Integer.valueOf(AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SET_EVENTCONFIG_RESP), "Email");
        f4832a.put(1028, "Subject");
        f4832a.put(1029, "Message");
        f4832a.put(1030, "Last Updated: ");
        f4832a.put(1031, "Add Attachment");
        f4832a.put(1032, "Send Feedback");
        f4832a.put(1033, "Add a Response");
        f4832a.put(1034, "Refresh");
        f4832a.put(1035, "Feedback");
        f4832a.put(1036, "Message couldn't be posted. Please check your input values and your connection, then try again.");
        f4832a.put(1037, "No response from server. Please check your connection, then try again.");
        f4832a.put(1038, "Please enter a subject");
        f4832a.put(1041, "Please enter a name");
        f4832a.put(1042, "Please enter an email address");
        f4832a.put(1043, "Please enter a feedback text");
        f4832a.put(1039, "Message couldn't be posted. Please check the format of your email address.");
        f4832a.put(1040, "An error has occured");
        f4832a.put(1280, "Please enter your account credentials.");
        f4832a.put(1281, "Please fill in the missing account credentials.");
        f4832a.put(1282, "Email");
        f4832a.put(1283, "Password");
        f4832a.put(1284, "Login");
        f4832a.put(1536, "Draw something!");
        f4832a.put(1537, "Save");
        f4832a.put(1538, "Undo");
        f4832a.put(1539, "Clear");
        f4832a.put(1540, "Discard your drawings?");
        f4832a.put(1541, "No");
        f4832a.put(1542, "Yes");
    }

    public static String a(f fVar, int i) {
        return f4832a.get(Integer.valueOf(i));
    }
}
