package com.sunmi.samples.printerx.ui.vm

import android.graphics.BitmapFactory
import android.view.View
import androidx.lifecycle.ViewModel
import com.sunmi.printerx.enums.Command
import com.sunmi.samples.printerx.R

class LcdViewModel: ViewModel(){

    /**
     * 初始化并清屏操作
     * 其他操作可参考文档中Command命令
     * 注意在不支持客显的设备上调用接口将返回异常
     *
     * * Initialize and clear screen operation
     * For other operations, please refer to the Command command in the document
     * Note that calling the interface on a device that does not support guest display will return an exception
     */
    fun lcdCtrl() {
        try {
            selectPrinter?.lcdApi()?.config(Command.INIT)
            selectPrinter?.lcdApi()?.config(Command.CLEAR)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    /**
     * 显示单行内容
     * 可根据具体情况设置字体大小
     * 可根据显示情况决定是否拉伸字体到屏幕高度
     *
     * * Display single line content
     * The font size can be set according to the specific situation
     * You can decide whether to stretch the font to the height of the screen according to the display situation
     */
    fun lcdLine() {
        try {
            selectPrinter?.lcdApi()?.config(Command.CLEAR)
            selectPrinter?.lcdApi()?.showText("SUNMI", 32, true)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    /**
     * 显示多行内容
     * 多行内容展示字体大小固定由所在行比例控制
     *
     * * Display multiple lines of content
     * The font size of multi-line content display is fixed and controlled by the proportion of the line
     */
    fun lcdLines() {
        try {
            selectPrinter?.lcdApi()?.config(Command.CLEAR)
            selectPrinter?.lcdApi()?.showTexts(arrayOf("ABCDEF", "123456"), intArrayOf(1, 1))
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    /**
     * 显示位图
     * 位图大小需要限制在128*40像素内
     *
     * * Display bitmap
     * Bitmap size needs to be limited to 128*40 pixels
     */
    fun lcdLogo(view:View) {
        try {
            val option: BitmapFactory.Options = BitmapFactory.Options().apply {
                inScaled = false
            }
            val bitmap = BitmapFactory.decodeResource(view.context.resources, R.drawable.test, option)
            selectPrinter?.lcdApi()?.config(Command.CLEAR)
            selectPrinter?.lcdApi()?.showBitmap(bitmap)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}