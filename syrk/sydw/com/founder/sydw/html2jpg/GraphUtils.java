package com.founder.sydw.html2jpg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.UUID;

import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicEditorPaneUI;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import com.cxsoft.rap.ed.util.ManualUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import sun.misc.BASE64Encoder;

public class GraphUtils {

	private final static Log log = LogFactory.getLog(GraphUtils.class);

	public static int DEFAULT_IMAGE_WIDTH = 910;

	// 默认值最好设置大点，因为我们再导之前，不知道这个流有多大，如果过小，则生成的图片后面的为黑色，因为流没有读取完整
	public static int DEFAULT_IMAGE_HEIGHT = 1280;

	/**
	 * 将ＢｕｆｆｅｒｅｄＩｍａｇｅ转换为图片的信息
	 * 
	 * @param image
	 * @return
	 */
	public static byte[] toJpegByteArray(BufferedImage image) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
			param.setQuality(1.0f, false);
			encoder.setJPEGEncodeParam(param);
			encoder.encode(image);
			byte[] buff = baos.toByteArray();
			baos.close();
			// 将字节流写入文件保存为图片
			System.out.println("保存成功!...." + buff.length);
			return buff;
		} catch (Exception ex) {
			log.error("保存删除图片失败:" + ex.getMessage());
		}
		return null;
	}

	/**
	 * 将ＢｕｆｆｅｒｅｄＩｍａｇｅ转换为图片的信息
	 * 
	 * @param image
	 * @return
	 */
	public static String toJpeg(BufferedImage image) {
		// 获取图片文件的在服务器的路径
		String imageName = "E:\\" + UUID.randomUUID().toString() + ".jpg";
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
			param.setQuality(1.0f, false);
			encoder.setJPEGEncodeParam(param);
			encoder.encode(image);
			byte[] buff = baos.toByteArray();
			baos.close();
			// 将字节流写入文件保存为图片
			FileUtils.writeByteArrayToFile(new File(imageName), buff);
			System.out.println("保存成功!....");
		} catch (Exception ex) {
			log.error("保存删除图片失败:" + ex.getMessage());
		}
		return imageName;
	}

	/**
	 * html转换为ｊｐｅｇ文件
	 * 
	 * @param bgColor
	 *            图片的背景色
	 * @param html
	 *            html的文本信息
	 * @param width
	 *            显示图片的Ｔｅｘｔ容器的宽度
	 * @param height
	 *            显示图片的Ｔｅｘｔ容器的高度
	 * @param eb
	 *            設置容器的边框
	 * @return
	 * @throws Exception
	 */
	private static byte[] html2jpeg(Color bgColor, String html, int width, int height, EmptyBorder eb)
			throws Exception {
		try {
			JTextPane tp = new JTextPane();
			tp.setSize(width, height);
			if (eb == null) {
				eb = new EmptyBorder(0, 50, 0, 50);
			}
			if (bgColor != null) {
				tp.setBackground(bgColor);
			}
			if (width <= 0) {
				width = DEFAULT_IMAGE_WIDTH;
			}
			if (height <= 0) {
				height = DEFAULT_IMAGE_HEIGHT;
			}
			tp.setBorder(eb);
			tp.setContentType("text/html");
			tp.setText(html);
			Dimension d = ((BasicEditorPaneUI) tp.getUI()).getPreferredSize(tp);
			// 此处是将一个页面生成一张图片，如果要人为控制图片大小进行分页生成，则再自行进行高度设置
			//但是分页之后可能出现的情况就是分页的时候字体被截断的可能，因为在截断的之后，他不知道流是否刚好将一行字显示完成
			if (d.height > DEFAULT_IMAGE_HEIGHT) {
				height = d.height;
			}
			PrintView m_printView = new PrintView(tp);
			BufferedImage image = new java.awt.image.BufferedImage(width, height,
					java.awt.image.BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			g.setClip(0, 0, width, height);
			m_printView.paintPage(g, height, 1);
			g.dispose();
			return toJpegByteArray(image);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * 将一個html转换为图片
	 * 
	 * @param htmls
	 * @return
	 * @throws Exception
	 */
	public static byte[] toImages(String html) throws Exception {
		return html2jpeg(null, html, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT, new EmptyBorder(0, 0, 0, 0));
	}

	public static void main(String[] args) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<!DOCTYPE html>                                                                                                                            ");
			sb.append("<html>                                                                                                                                     ");
			sb.append("<head>                                                                                                                                     ");
			sb.append("<title>技防检查通知书</title>                                                                                                              ");
			sb.append("<style>                                                                                                                                    ");
			sb.append("td{                                                                                                                                        ");
			sb.append("	font-family:楷体;                                                                                                                         ");
			sb.append("	font-size:15px;                                                                                                                           ");
			sb.append("	word-break : break-all;                                                                                                                   ");
			sb.append("	vertical-align: top;                                                                                                                      ");
			sb.append("}                                                                                                                                          ");
			sb.append(".title1{                                                                                                                                   ");
			sb.append("	text-align:center;                                                                                                                        ");
			sb.append("	font-size: 18px;                                                                                                                          ");
			sb.append("	font-weight:700;                                                                                                                          ");
			sb.append("}                                                                                                                                          ");
			sb.append(".title2{                                                                                                                                   ");
			sb.append("	text-align:center;                                                                                                                        ");
			sb.append("	font-size: 18px;                                                                                                                          ");
			sb.append("	font-weight:700;                                                                                                                          ");
			sb.append("}                                                                                                                                          ");
			sb.append(".wh{                                                                                                                                       ");
			sb.append("	text-align:right;                                                                                                                         ");
			sb.append("	font-size: 18px;                                                                                                                          ");
			sb.append("	font-weight:700;                                                                                                                          ");
			sb.append("}                                                                                                                                          ");
			sb.append("table{                                                                                                                                     ");
			sb.append("	border='0' cellpadding='0' cellspacing='6';                                                                                               ");
			sb.append("}                                                                                                                                          ");
			sb.append("</style>                                                                                                                                   ");
			sb.append("</head>                                                                                                                                    ");
			sb.append("<body>                                                                                                                                     ");
			sb.append("	<div style='width:700px;height:978px;padding: 20px;border:1px solid #000000;margin:20px;'>                                                ");
			sb.append("		<table style='width:594px;' width='100%' align='center'>                                                                              ");                                                                                                                     
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td class='title1'>                                                                                                           ");
			sb.append("					<span style='text-decoration:underline;'>                                                                                 ");
			sb.append("					xxxxx                                                                                                                     ");
			sb.append("					</span>公安（分）局                                                                                                       ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("         </tr>");
			sb.append("				<td class='title2'>   公共安全技术防范检查记录                                                                                                         ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td style='text-align: right;'>                                                                                               ");
			sb.append("					<span style='text-decoration:underline;'>                                                                                 ");
			sb.append("						xxx                                                                                                                   ");
			sb.append("					</span>                                                                                                                   ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td>                                                                                                                          ");
			sb.append("					<span style='text-decoration:underline;'>                                                                                 ");
			sb.append("						dwmc                                                                                                                  ");
			sb.append("					</span>：                                                                                                                 ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td >                                                                                                                         ");
			sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;经调查，发现你单（位）存在下述违法行为：                                                              ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td style='padding-left: 50px;padding-right: 50px;height: 200px;' valign='top''>                                              ");
			sb.append("				${entity.wfxw}                                                                                                                ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td >                                                                                                                         ");
			sb.append("					<table>                                                                                                                   ");
			sb.append("						<tr>                                                                                                                  ");
			sb.append("							<td >&nbsp;&nbsp;&nbsp;根据：</td>                                                                                ");
			sb.append("							<td style='width:350px;border-bottom:1px solid #000;'>fg《禁止娱乐场所卖淫嫖娼行为蔓延政治专项法规》</td>                                                     ");
			sb.append("						    <td >                                                                                                                  ");
			sb.append("							之规定，现责令你（单位）                                                                                          ");
			sb.append("							</td>                                                                                                             ");
			sb.append("						</tr>                                                                                                                 ");
			sb.append("					</table>                                                                                                                  ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td >                                                                                                                         ");
			sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;□立即予以改正 ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td >                                                                                                                         ");
			sb.append("			    &nbsp;&nbsp;&nbsp;&nbsp;□立即                                                                              ");
			sb.append("							gznr______                                                  ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td>    ");
			sb.append("				 &nbsp;&nbsp;&nbsp;&nbsp;☑ 在   ");
			sb.append("				              <span style='text-decoration:underline;'>gzsj</span>                                                            ");
			sb.append("						前改正或者整改完毕，并将结果函告我单位。在期限届满之前，你（单位）必须                                                ");
			sb.append("				              <span style='text-decoration:underline;'>zgsx</span>。                                                          ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td >                                                                                                                         ");
			sb.append("				如不服本决定，可在收到本通知书之日起六十日内向                                                                                ");
			sb.append("				<span style='text-decoration:underline;'>fydwmc</span>                                                                        ");
			sb.append("				申请行政复议或者在六个月内依法向                                                                                              ");
			sb.append("				<span style='text-decoration:underline;'>fymc</span>                                                                          ");
			sb.append("				人民法院提起行政诉讼。                                                                                                        ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr  align='right' style='padding-top: 260px'>                                                                                    ");
			sb.append("				<td>                                                                                                                          ");
			sb.append("				　　 公安机关（印）                                                                                                           ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr  align='right'>                                                                                                               ");
			sb.append("				<td>                                                                                                                          ");
			sb.append("				　　<span style='text-decoration:underline;'>fhrq</span>                                                                      ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td>                                                                                                                          ");
			sb.append("					<table>                                                                                                                   ");
			sb.append("						<tr>                                                                                                                  ");
			sb.append("							<td >　　违法行为人</td>                                                                                          ");
			sb.append("							<td style='width:200px;border-bottom:1px solid #000;'>wfxwr</td>                                                  ");
			sb.append("						<tr>                                                                                                                  ");
			sb.append("					</table>                                                                                                                  ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("			<tr >                                                                                                                             ");
			sb.append("				<td >                                                                        ");
			sb.append("					<table style='width:200px;border-bottom:1px solid #000;'><tr><td>hgrq</td></tr></table>                                                                                                                      ");
			sb.append("				</td>                                                                                                                         ");
			sb.append("			</tr>                                                                                                                             ");
			sb.append("		</table>                                                                                                                              ");
			sb.append("	</div>                                                                                                                                    ");
			sb.append("</body>                                                                                                                                    ");
			sb.append("</html>                                                                                                                                    ");

			byte[] jpgByteArray = GraphUtils.toImages(sb.toString());
			
			System.out.println("====================================");
			int count = 1;
			for(byte b : jpgByteArray){
				if(count < 10){
					System.out.println(b);
					count++;
				}
			}
			System.out.println();
			System.out.println(new BASE64Encoder().encode(jpgByteArray).substring(0, 9));
			System.out.println();
			System.out.println("=====================================");
			
			//测试用，看看生成的流是否正确
			String imageName = "E:\\" + UUID.randomUUID().toString() + ".jpg";
			// 将字节流写入文件保存为图片
			FileUtils.writeByteArrayToFile(new File(imageName), jpgByteArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
