package com.tgb.util;


/* *
 *类名：Config
 *功能：基础配置类
 *日期：2017-08-10
 *说明：
*/

public class Config {

  //公钥
	public static String public_key = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANckZ1iK/1sOb7N1n2xuwiIoHZtJ3mgaV3s0PCcJKhdV5MsjQ/yzQ5N4lnQd9RyLjVfDH6M6KNDSmPc+rmRFRH0CAwEAAQ==";

	//私钥
	public static String private_key = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEA1yRnWIr/Ww5vs3WfbG7CIigdm0neaBpXezQ8JwkqF1XkyyND/LNDk3iWdB31HIuNV8Mfozoo0NKY9z6uZEVEfQIDAQABAkArmSv8TIa9DCrkwkRhc/yRcXG2g3y3ugbaZ9Z8zqWh/p2bU0ih2EdhqCl1M9QzOlmwdgL6dOZtupr93cvPwb2dAiEA/8plzQ4y0xGqbRjDai4KfEwgNQ57T0f74giFqErHzRsCIQDXUXzpRbnMqksB/SrT45BzPUH4eEIoYQ2ZBuEVuLJGRwIhANufHlU30a+kRV4ymuZ57YrXmfe0HW/u8HgctRXQT0jtAiBqPCNkOOm+KDtP5OhPmRS5Nv0oqbUClTgPS4ycmf8jmwIgfKUvHfL+DBr0mhee0kXE//RVOHUORv9jgyFL7TK1W6s=";

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "/opt/d/logs";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 签名方式 不需修改
	public static String sign_type = "RSA";

}
