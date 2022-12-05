package com.sunmi.samples.printerx.ui.vm

import android.view.View
import androidx.lifecycle.ViewModel
import com.sunmi.samples.printerx.utils.BluetoothUtil
import java.nio.charset.StandardCharsets

class CmdViewModel : ViewModel() {

    /**
     * 通过接口打印指令数据 -> Print command data through the interface
     */
    fun testEsc() {
        selectPrinter?.commandApi()?.sendEscCommand(getMeituanBill())
    }

    /**
     * 通过接口打印指令数据 -> Print command data through the interface
     */
    fun testTspl() {
        selectPrinter?.commandApi()?.sendTsplCommand(getTsplData())
    }

    /**
     * 通过内置虚拟蓝牙通信打印指令数据 -> Print command data via built-in virtual Bluetooth communication
     */
    fun testBluetoothEsc(view:View) {
        if(BluetoothUtil.connectBlueTooth(view.context)){
            BluetoothUtil.sendData(getMeituanBill())
            BluetoothUtil.disconnectBlueTooth(view.context)
        }
    }

    /**
     * 通过内置虚拟蓝牙通信打印指令数据 -> Print command data via built-in virtual Bluetooth communication
     */
    fun testBluetoothTspl(view: View) {
        if(BluetoothUtil.connectBlueTooth(view.context)){
            BluetoothUtil.sendData(getTsplData())
            BluetoothUtil.disconnectBlueTooth(view.context)
        }
    }

    /**
     * 美团小票ESC样张 -> Meituan small ticket ESC proof
     */
    private fun getMeituanBill(): ByteArray {
        return byteArrayOf(
            0x1b,
            0x40,
            0x1b,
            0x61,
            0x01,
            0x1d,
            0x21,
            0x11,
            0xa3.toByte(),
            0xa3.toByte(),
            0x31,
            0x20,
            0x20,
            0xc3.toByte(),
            0xc0.toByte(),
            0xcd.toByte(),
            0xc5.toByte(),
            0xb2.toByte(),
            0xe2.toByte(),
            0xca.toByte(),
            0xd4.toByte(),
            0x0a,
            0x0a,
            0x1d,
            0x21,
            0x00,
            0xd4.toByte(),
            0xc1.toByte(),
            0xcf.toByte(),
            0xe3.toByte(),
            0xb8.toByte(),
            0xdb.toByte(),
            0xca.toByte(),
            0xbd.toByte(),
            0xc9.toByte(),
            0xd5.toByte(),
            0xc0.toByte(),
            0xb0.toByte(),
            0x28,
            0xb5.toByte(),
            0xda.toByte(),
            0x31,
            0xc1.toByte(),
            0xaa.toByte(),
            0x29,
            0x0a,
            0x1b,
            0x21,
            0x10,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x0a,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x20,
            0xd4.toByte(),
            0xa4.toByte(),
            0xb6.toByte(),
            0xa9.toByte(),
            0xb5.toByte(),
            0xa5.toByte(),
            0x20,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x20,
            0x2a,
            0x0a,
            0xc6.toByte(),
            0xda.toByte(),
            0xcd.toByte(),
            0xfb.toByte(),
            0xcb.toByte(),
            0xcd.toByte(),
            0xb4.toByte(),
            0xef.toByte(),
            0xca.toByte(),
            0xb1.toByte(),
            0xbc.toByte(),
            0xe4.toByte(),
            0x3a,
            0x20,
            0x5b,
            0x31,
            0x38,
            0x3a,
            0x30,
            0x30,
            0x5d,
            0x0a,
            0x1d,
            0x21,
            0x00,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x0a,
            0x1b,
            0x61,
            0x00,
            0xcf.toByte(),
            0xc2.toByte(),
            0xb5.toByte(),
            0xa5.toByte(),
            0xca.toByte(),
            0xb1.toByte(),
            0xbc.toByte(),
            0xe4.toByte(),
            0x3a,
            0x30,
            0x31,
            0x2d,
            0x30,
            0x31,
            0x20,
            0x31,
            0x32,
            0x3a,
            0x30,
            0x30,
            0x0a,
            0x1b,
            0x21,
            0x10,
            0xb1.toByte(),
            0xb8.toByte(),
            0xd7.toByte(),
            0xa2.toByte(),
            0x3a,
            0xb1.toByte(),
            0xf0.toByte(),
            0xcc.toByte(),
            0xab.toByte(),
            0xc0.toByte(),
            0xb1.toByte(),
            0x0a,
            0x1d,
            0x21,
            0x00,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x0a,
            0xb2.toByte(),
            0xcb.toByte(),
            0xc3.toByte(),
            0xfb.toByte(),
            0x09,
            0x09,
            0x20,
            0x20,
            0x20,
            0xca.toByte(),
            0xfd.toByte(),
            0xc1.toByte(),
            0xbf.toByte(),
            0x09,
            0x20,
            0x20,
            0x20,
            0x20,
            0xd0.toByte(),
            0xa1.toByte(),
            0xbc.toByte(),
            0xc6.toByte(),
            0x09,
            0x0a,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x0a,
            0x1b,
            0x21,
            0x10,
            0xba.toByte(),
            0xec.toByte(),
            0xc9.toByte(),
            0xd5.toByte(),
            0xc8.toByte(),
            0xe2.toByte(),
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x78,
            0x31,
            0x09,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x31,
            0x32,
            0x0a,
            0x1d,
            0x21,
            0x00,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x0a,
            0xc5.toByte(),
            0xe4.toByte(),
            0xcb.toByte(),
            0xcd.toByte(),
            0xb7.toByte(),
            0xd1.toByte(),
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x35,
            0x0a,
            0xb2.toByte(),
            0xcd.toByte(),
            0xba.toByte(),
            0xd0.toByte(),
            0xb7.toByte(),
            0xd1.toByte(),
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x31,
            0x0a,
            0x5b,
            0xb3.toByte(),
            0xac.toByte(),
            0xca.toByte(),
            0xb1.toByte(),
            0xc5.toByte(),
            0xe2.toByte(),
            0xb8.toByte(),
            0xb6.toByte(),
            0x5d,
            0x20,
            0x2d,
            0xcf.toByte(),
            0xea.toByte(),
            0xbc.toByte(),
            0xfb.toByte(),
            0xb6.toByte(),
            0xa9.toByte(),
            0xb5.toByte(),
            0xa5.toByte(),
            0x0a,
            0xbf.toByte(),
            0xc9.toByte(),
            0xbf.toByte(),
            0xda.toByte(),
            0xbf.toByte(),
            0xc9.toByte(),
            0xc0.toByte(),
            0xd6.toByte(),
            0x3a,
            0x78,
            0x31,
            0x0a,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x0a,
            0x1b,
            0x21,
            0x10,
            0xba.toByte(),
            0xcf.toByte(),
            0xbc.toByte(),
            0xc6.toByte(),
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x20,
            0x31,
            0x38,
            0xd4.toByte(),
            0xaa.toByte(),
            0x0a,
            0x1b,
            0x40,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x0a,
            0x1d,
            0x21,
            0x11,
            0xd5.toByte(),
            0xc5.toByte(),
            0x2a,
            0x20,
            0x31,
            0x38,
            0x33,
            0x31,
            0x32,
            0x33,
            0x34,
            0x35,
            0x36,
            0x37,
            0x38,
            0x0a,
            0xb5.toByte(),
            0xd8.toByte(),
            0xd6.toByte(),
            0xb7.toByte(),
            0xd0.toByte(),
            0xc5.toByte(),
            0xcf.toByte(),
            0xa2.toByte(),
            0x0a,
            0x1d,
            0x21,
            0x00,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x2d,
            0x0a,
            0x0a,
            0x1b,
            0x40,
            0x1b,
            0x61,
            0x01,
            0x1d,
            0x21,
            0x11,
            0xa3.toByte(),
            0xa3.toByte(),
            0x31,
            0x20,
            0x20,
            0xc3.toByte(),
            0xc0.toByte(),
            0xcd.toByte(),
            0xc5.toByte(),
            0xb2.toByte(),
            0xe2.toByte(),
            0xca.toByte(),
            0xd4.toByte(),
            0x0a,
            0x1d,
            0x21,
            0x00,
            0x1b,
            0x40,
            0x0a,
            0x0a,
            0x0a,
            0x0a
        )
    }

    private fun getTsplData(): ByteArray {
        val content = "SIZE 40 mm, 30 mm\r\n" +
                "GAP 3 mm, 0 mm\r\n" +
                "DIRECTION 1,0\r\n" +
                "REFERENCE 0,0\r\n" +
                "SET TEAR 1\r\n" +
                "CLS\r\n" +
                "TEXT 20,10, \"test.ttf\",0,1,1,\"first line!\"\r\n" +
                "TEXT 20,51, \"test.ttf\",0,1,1,\"second line!\"\r\n" +
                "TEXT 20,92, \"test.ttf\",0,1,1,\"third line!\"\r\n" +
                "TEXT 20,133, \"test.ttf\",0,1,1,\"firth line!\"\r\n" +
                //"BARCODE 40,165,\"128\",40,1,0,2,2,\"1234567890\"\r\n" +
                "QRCODE 40,165,L, 4, A, 0,\"abcdefg\"\r\n" +
                "PRINT 1,2\r\n"
        return content.toByteArray(StandardCharsets.UTF_8)
    }

}