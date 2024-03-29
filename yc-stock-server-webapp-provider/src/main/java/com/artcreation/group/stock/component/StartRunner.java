package com.artcreation.group.stock.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;



/**
 * @author 123
 */
@Component
@ConfigurationProperties(prefix = "server")
public class StartRunner implements ApplicationRunner {
    @Value("${server.port}")
    private String port;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String url_format = "http://%s:%s%s/swagger-ui.html#";
        String ip = null;
        try {
//            ip = IpUtil.getIpAddress();
//            if (null == ip || "".equals(ip)) {
//                ip = "127.0.0.1";
//            }
//            if (null == port || "".equals(port)) {
//                port = "8080";
//            }
            String url = String.format(url_format, "127.0.0.1", port,contextPath);
            browse(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    private void browse(String url) throws Exception {
        // 获取操作系统的名字
        String osName = System.getProperty("os.name", "");
        if (osName.startsWith("Mac OS")) {
            // 苹果的打开方式
            Class fileMgr = Class.forName("com.apple.eio.FileManager");
            Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[]{String.class});
            openURL.invoke(null, new Object[]{url});
        } else if (osName.startsWith("Windows")) {
            // windows的打开方式。
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } else {
            // Unix or Linux的打开方式
            String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"};
            String browser = null;
            for (int count = 0; count < browsers.length && browser == null; count++)
                // 执行代码，在brower有值后跳出，
                // 这里是如果进程创建成功了，==0是表示正常结束。
                if (Runtime.getRuntime().exec(new String[]{"which", browsers[count]}).waitFor() == 0)
                    browser = browsers[count];
            if (browser == null)
                throw new Exception("Could not find web browser");
            else
                // 这个值在上面已经成功的得到了一个进程。
                Runtime.getRuntime().exec(new String[]{browser, url});
        }
    }
}
