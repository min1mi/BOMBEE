/* Spring WebMVC: JSON 콘텐츠로 응답하기 + 파일 업로드
 * => AJAX 파일 업로드
 */
package bitcamp.java93.control.json;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java93.domain.Usermeal;
import bitcamp.java93.service.UsermealService;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/management/mealphoto/") 
public class UsermealPhotoControl {

  @Autowired UsermealService usermealService;
  @Autowired ServletContext ctx;

  @RequestMapping(path="upload")
  public JsonResult upload(Usermeal usermeal, MultipartFile[] files, HttpSession session) throws Exception {
    
    String newFilename = this.getNewFilename();
    File file = new File(ctx.getRealPath("/upload/" + newFilename));
    files[0].transferTo(file);

    usermeal.setMealpicture("/upload/" + newFilename);
    
    File thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_140"));
    Thumbnails.of(file).size(140, 140).outputFormat("png").toFile(thumbnailfile);
    
    thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_350"));
    Thumbnails.of(file).size(350, 350).outputFormat("png").toFile(thumbnailfile);
    
    System.out.println(usermeal);
    usermealService.add(usermeal);
    
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping(path="update")
  public JsonResult upload(Usermeal usermeal, MultipartFile[] files) throws Exception {

    String newFilename = this.getNewFilename();
    File file = new File(ctx.getRealPath("/upload/" + newFilename));
    files[0].transferTo(file);

    usermeal.setMealpicture("/upload/" + newFilename);
    
    File thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_140"));
    Thumbnails.of(file).size(140, 140).outputFormat("png").toFile(thumbnailfile);
    
    thumbnailfile = new File(ctx.getRealPath("/upload/" + newFilename + "_350"));
    Thumbnails.of(file).size(350, 350).outputFormat("png").toFile(thumbnailfile);
    
    System.out.println(usermeal);
    usermealService.add(usermeal);
    
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }


  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }
}









































