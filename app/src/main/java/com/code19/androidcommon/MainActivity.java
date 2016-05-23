/*
 *   Copyright (C)  2016 android@19code.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.code19.androidcommon;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.code19.library.DeviceUtils;
import com.code19.library.FileUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ghost";
    private Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fire = (Button) findViewById(R.id.fire);
        Button dial = (Button) findViewById(R.id.dial);

        if (fire != null) {
            fire.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean b = FileUtils.deleteFile(c.getCacheDir().getAbsolutePath() + "/" + "a");
                    boolean b1 = c.deleteFile(c.getCacheDir().getAbsolutePath() + "/" + "a");
                    Log.i(TAG, "利用上下文删除: " + b);
                }
            });
        }
        if (dial != null) {
            dial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean b = FileUtils.deleteFile(c.getCacheDir().getAbsolutePath());
                    Log.i("ghost", "删除目录下的文件:" + b);
                }
            });
        }
    }

    public void share() {
        Log.i(TAG, "getStore: " + DeviceUtils.getStore(c));
    }
}
