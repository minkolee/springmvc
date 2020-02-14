package cc.conyli.web;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/body")
public class BodyController {

    //入参转换成字符串
    @RequestMapping("/inner")
    public ResponseEntity<String> inBound(HttpEntity<String> httpEntity) {

        System.out.println(httpEntity.getHeaders());
        System.out.println(httpEntity.getBody());

        return new ResponseEntity<>("index", HttpStatus.OK);
    }


    @RequestMapping("/byteimage")
    public ResponseEntity<byte[]> image() throws IOException {
        Resource file = new FileSystemResource("C:\\Users\\Minko\\Pictures\\mhwi2.jpg");
        return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file.getInputStream()), HttpStatus.OK);
    }
}
