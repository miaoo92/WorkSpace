package com.imooc.web.template.engine;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/9/12
 */
public class ThymeleafTemplateEngineBootstrap {

   /* public static void main(String[] args) throws IOException {

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();

        Context context = new Context();

        context.setVariable("message","Hello,World");

        //读取内容从  classpath:\templates\thymeleaf\hello-world.html
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");
        File templateFile = resource.getFile();
        //文件流
        FileInputStream fis = new FileInputStream(templateFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        IOUtils.copy(fis,outputStream);
        fis.close();

        String content = outputStream.toString("UTF-8");

        String result = templateEngine.process(content,context);

        System.out.println(result);
    }*/
}
