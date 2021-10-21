package de.tensing.bossteam.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

public class QrCodeGenerator {

    public static BufferedImage generateQrCodeFrom(String text, int width, int height) {
        QRCodeWriter codeWriter = new QRCodeWriter();
        BitMatrix bitMatrix;
        try {
            bitMatrix = codeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        } catch (WriterException e) {
            throw new RuntimeException("Error while generating Qr Code", e);
        }
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

}
