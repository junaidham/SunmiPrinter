package com.sunmi.samples.printerx;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sunmi.printerx.PrinterSdk;
import com.sunmi.printerx.SdkException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * SUNMI printers for specified operations
     */
    public PrinterSdk.Printer selectPrinter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer);
        if(savedInstanceState == null) {
            switchFragment(MainFragment.class);
        }

        initPrinter();
    }

    /**
     * Initialize the default printer as the printing device to be operated
     */
    private void initPrinter() {
        try {
            PrinterSdk.getInstance().getPrinter(this, new PrinterSdk.PrinterListen() {
                @Override
                public void onDefPrinter(PrinterSdk.Printer printer) {
                    selectPrinter = printer;
                }

                @Override
                public void onPrinters(List<PrinterSdk.Printer> printers) {

                }
            });
        } catch (SdkException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_swtich, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_log_off:
                PrinterSdk.getInstance().log(false);
                break;
            case R.id.action_log_on:
                PrinterSdk.getInstance().log(true);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void switchFragment(Class<? extends Fragment> fragmentClass) {
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container, fragmentClass, null)
                .commit();
    }

    public void switchFragment(Class<? extends Fragment> fragmentClass, boolean isBack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container, fragmentClass, null);
        if(isBack) {
            transaction.addToBackStack(fragmentClass.getSimpleName());
        }
        transaction.commit();
    }
}
