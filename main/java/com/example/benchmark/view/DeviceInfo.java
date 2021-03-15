package com.example.benchmark.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.benchmark.R;

public class DeviceInfo extends AppCompatActivity {
    String _OSVERSION = System.getProperty("os.version");
    String _RELEASE = android.os.Build.VERSION.RELEASE;
    String _DEVICE = android.os.Build.DEVICE;
    String _MODEL = android.os.Build.MODEL;
    String _PRODUCT = android.os.Build.PRODUCT;
    String _BRAND = android.os.Build.BRAND;
    String _DISPLAY = android.os.Build.DISPLAY;
    String _CPU_ABI = android.os.Build.CPU_ABI;
    String _CPU_ABI2 = android.os.Build.CPU_ABI2;
    String _UNKNOWN = android.os.Build.UNKNOWN;
    String _HARDWARE = android.os.Build.HARDWARE;
    String _ID = android.os.Build.ID;
    String _MANUFACTURER = android.os.Build.MANUFACTURER;
    String _SERIAL = android.os.Build.SERIAL;
    String _USER = android.os.Build.USER;
    String _HOST = android.os.Build.HOST;
    int _SDK = android.os.Build.VERSION.SDK_INT;


    TextView devInfo_label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);

        devInfo_label = (TextView) findViewById(R.id.devInfo_label);
        devInfo_label.setText(
                "Version: " + _OSVERSION + "\n" +
                "Release: " + _RELEASE + "\n" +
                        "Device: " +  _DEVICE + "\n" +
                        "Model: " +_MODEL + "\n" +
                "Product: " + _PRODUCT + "\n" +
                "Brand: " +_BRAND+ "\n" +
                "Display: " +_DISPLAY+ "\n" +
                "CPU ABI: " +_CPU_ABI+ "\n" +
                "CPU ABI2: " + _CPU_ABI2+ "\n" +
                "Unknown: " +_UNKNOWN+ "\n" +
                "Hardware: " +_HARDWARE+ "\n" +
                "ID: " +_ID+ "\n" +
                "Manufacturer: " +_MANUFACTURER+ "\n" +
                "Serial: " +_SERIAL+ "\n" +
                "User: " +_USER+ "\n" +
                "Host: " +_HOST+ "\n" +
                "SDK: " +_SDK+ "\n"
        );
    }
}