package com.sunmi.samples.printerx.ui.vm

import android.graphics.BitmapFactory
import android.view.View
import androidx.lifecycle.ViewModel
import com.sunmi.printerx.api.PrintResult
import com.sunmi.printerx.enums.*
import com.sunmi.printerx.style.*
import com.sunmi.samples.printerx.R

class TicketViewModel : ViewModel(){

    /**
     * 文本打印例子
     * 通过initLine设置行内大小和行内文本对齐方式
     * 通过printText直接打印整行内容
     * 通过addText控制每次打印的内容
     * 局部反白和文本倒置需要Sunmi 3.0字体支持
     *
     * Text printing example
     * Set inline size and inline text alignment through initLine
     * Directly print the entire line through printText
     * Control the content of each print by addText
     * Partial highlighting and text inversion require Sunmi 3.0 font support
     */
    fun printText() {
        selectPrinter?.lineApi()?.run {
            initLine(BaseStyle.getStyle())
            printText("This line will be printed directly", TextStyle.getStyle())
            addText("Different styles of content:", TextStyle.getStyle())
            addText("Bold", TextStyle.getStyle().enableBold(true))
            addText("Underline", TextStyle.getStyle().enableUnderline(true))
            addText("Strikethrough", TextStyle.getStyle().enableStrikethrough(true))
            addText("Tilt", TextStyle.getStyle().enableItalics(true))
            addText("\n", TextStyle.getStyle())
            autoOut()
        }
    }

    /**
     * 按列打印文本例子 ->Example of printing text by column
     *  | * | * | * |
     *  |*  | * |  *|
     *  |*  |*  |*  |
     */
    fun printTexts() {
        selectPrinter?.lineApi()?.run {
            val textStyle = TextStyle.getStyle().setAlign(Align.CENTER)
            printTexts(arrayOf("first column","second column","third column"), intArrayOf(1, 1, 1), arrayOf(textStyle, textStyle, textStyle))
            printTexts(arrayOf("first column","second column","third column"), intArrayOf(1, 1, 1),
                arrayOf(TextStyle.getStyle().setAlign(Align.LEFT),
                    TextStyle.getStyle().setAlign(Align.CENTER),
                    TextStyle.getStyle().setAlign(Align.RIGHT)))
            val textStyle1 = TextStyle.getStyle().setAlign(Align.LEFT)
            printTexts(arrayOf("first column","second column","third column"), intArrayOf(1, 1, 1), arrayOf(textStyle1, textStyle1, textStyle1))
            autoOut()
        }
    }

    /**
     * 打印条码例子
     * 演示打印几段条码内容
     * 如果条码内容过长会导致显示异常，此时需要根据需要自定义条码的宽度
     * （自定义条码宽度可能影响条码的识别效果）
     *
     * Print barcode example
     * Demonstrate printing a few sections of barcode content
     * If the content of the barcode is too long, it will cause abnormal display. At this time, you need to customize the width of the barcode according to your needs
     * (Customized barcode width may affect the barcode recognition effect)
     */
    fun printBar() {
        selectPrinter?.lineApi()?.run {
            val barcodeStyle = BarcodeStyle.getStyle().setAlign(Align.CENTER).setDotWidth(2).setBarHeight(100).setReadable(HumanReadable.POS_TWO)
            printBarCode("0123456789", barcodeStyle)
            printBarCode("0123456789ABCDEFG", barcodeStyle)
            barcodeStyle.setWidth(384)
            printBarCode("0123456789ABCDEFG", barcodeStyle)
            autoOut()
        }
    }

    /**
     * 打印Qr码例子 ->Print Qr code example
     */
    fun printQr() {
        selectPrinter?.lineApi()?.run {
            printQrCode("http://www.sunmi.com", QrStyle.getStyle().setAlign(Align.CENTER)
                .setDot(9).setErrorLevel(ErrorLevel.L))
            initLine(BaseStyle.getStyle().setAlign(Align.CENTER))
            printText("http://www.sunmi.com", TextStyle.getStyle().enableBold(true))
            autoOut()
        }
    }

    /**
     * 打印Logo的例子
     * 分别使用二值化处理图片和抖动算法处理图片
     * 由于logo本身透明背景橙色字体，使用二值化处理后通过设置阈值呈现不同效果
     *
     * Example of printing Logo
     * Use binarization to process pictures and dithering algorithms to process pictures respectively
     * Due to the orange font on the transparent background of the logo itself, different effects can be presented by setting the threshold after binarization
     */
    fun printBitmap(view: View) {
        selectPrinter?.lineApi()?.run {
            val option: BitmapFactory.Options = BitmapFactory.Options().apply {
                inScaled = false
            }
            val bitmap = BitmapFactory.decodeResource(view.context.resources, R.drawable.test, option)
            printBitmap(bitmap, BitmapStyle.getStyle().setAlign(Align.CENTER).setAlgorithm(ImageAlgorithm.BINARIZATION).setValue(120).setWidth(384).setHeight(150))
            printBitmap(bitmap, BitmapStyle.getStyle().setAlign(Align.CENTER).setAlgorithm(ImageAlgorithm.DITHERING).setWidth(384).setHeight(150))
            autoOut()
        }
    }

    /**
     * 打印分割线的例子
     * 分割线包括空白线，每行打印内容可以通过空白线进行分割
     *
     * Example of printing dividing lines
     * The dividing line includes blank lines, and the printed content of each line can be divided by blank lines
     */
    fun printLine() {
        selectPrinter?.lineApi()?.run {
            printDividingLine(DividingLine.EMPTY, 20)
            printDividingLine(DividingLine.DOTTED, 5)
            printDividingLine(DividingLine.EMPTY, 20)
            printDividingLine(DividingLine.SOLID, 10)
            autoOut()
        }
    }

    /**
     * 结合上面构建一个标准的小票内容 -> Combining the above to build a standard ticket content
     */
    fun printTicket(view: View) {
        selectPrinter?.lineApi()?.run {
            initLine(BaseStyle.getStyle().setAlign(Align.CENTER))
            addText("******", TextStyle.getStyle())
            addText("Sunmi House", TextStyle.getStyle().enableBold(true).setTextWidthRatio(1).setTextHeightRatio(1))
            printText( "******", TextStyle.getStyle())
            val option: BitmapFactory.Options = BitmapFactory.Options().apply {
                inScaled = false
            }
            val bitmap = BitmapFactory.decodeResource(view.context.resources, R.drawable.test, option)
            printBitmap(bitmap, BitmapStyle.getStyle().setAlign(Align.CENTER).setAlgorithm(ImageAlgorithm.BINARIZATION).setValue(120).setWidth(384).setHeight(150))
            printDividingLine(DividingLine.EMPTY, 30)
            printDividingLine(DividingLine.DOTTED, 2)
            printDividingLine(DividingLine.EMPTY, 30)
            val textStyle = TextStyle.getStyle().setAlign(Align.LEFT)
            printTexts(arrayOf("Product 1","Product 12","Product 13"), intArrayOf(1, 1, 1), arrayOf(textStyle, textStyle, textStyle))
            printTexts(arrayOf("Product 21","Product 22","Product 23"), intArrayOf(1, 1, 1), arrayOf(textStyle, textStyle, textStyle))
            printTexts(arrayOf("Product 31","Product 32","Product 33"), intArrayOf(1, 1, 1), arrayOf(textStyle, textStyle, textStyle))
            printText("Commodity information barcode information:", TextStyle.getStyle())
            printBarCode("1234567890", BarcodeStyle.getStyle().setAlign(Align.CENTER).setReadable(HumanReadable.POS_TWO))
            printDividingLine(DividingLine.EMPTY, 30)
            printDividingLine(DividingLine.DOTTED, 2)
            initLine(BaseStyle.getStyle().setAlign(Align.CENTER))
            printText("--Paid--", TextStyle.getStyle().setTextSize(48))
            printText("Estimated delivery at 19:00", TextStyle.getStyle().setTextSize(48))
            initLine(BaseStyle. getStyle(). setAlign(Align. LEFT))
            printText( "[order time] 2021-8-1 12:00", TextStyle.getStyle())
            addText("【Remarks】", TextStyle.getStyle())
            printText("Delivery as soon as possible", TextStyle.getStyle().setTextHeightRatio(2))
            printDividingLine(DividingLine. EMPTY, 30)
            printDividingLine(DividingLine. DOTTED, 2)
            printText("【Invoice header】", TextStyle.getStyle().setTextSize(16))
            printQrCode("1234567890", QrStyle.getStyle().setDot(9).setAlign(Align.CENTER))
            autoOut()
        }
    }

    /**
     * 需要监听打印结果时可以开启事务模式
     * 开启后每次打印内容时通过printTrans监听回调即可获取结果
     *
     * You can turn on the transaction mode when you need to monitor the print results
     * After it is turned on, the result can be obtained by listening to the callback through printTrans every time the content is printed
     */
    fun printTicketAndListen(view: View) {
        //需要监听打印结果时可以开启事务模式 -> The transaction mode can be turned on when the print result needs to be monitored
        selectPrinter?.lineApi()?.enableTransMode(true)

            //正常打印票据 -> Print receipt normally
        printTicket(view)
        //事务监听结果 -> Transaction monitoring results
        selectPrinter?.lineApi()?.printTrans(object : PrintResult() {
            override fun onResult(resultCode: Int, message: String?) {
                if(resultCode == 0) {
                    //打印完成 -> print complete
                } else {
                    //打印失败 ->print failed
                    println(selectPrinter?.queryApi()?.status)
                }
            }

        })
    }


}