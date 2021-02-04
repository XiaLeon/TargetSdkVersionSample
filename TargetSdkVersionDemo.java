
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.example.memorydemo.R;

public class TargetSdkVersionDemo extends Activity {
    @Override
    protected void onCreate(Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        setContentView(R.layout.target_sdk_version_demo);

        int appTargetSdkVersion = getApplicationInfo().targetSdkVersion;
        Log.i("TargetSdkVersionDemo", "targetsdkversion " + appTargetSdkVersion);
        if (appTargetSdkVersion <= Build.VERSION_CODES.O) {
            showNotSupportDialog(appTargetSdkVersion);
        }
    }

    private void showNotSupportDialog(int version) {
        new AlertDialog.Builder(this)
                .setMessage("该APP的目标运行版本是 " + version + "，低于手机当前的版本，不支持运行！")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // 退出程序
                        finish();
                    }
                })
                .create()
                .show();

    }
}
