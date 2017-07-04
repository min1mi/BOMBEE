  package bitcamp.java93.control.json;
/* ServletContext 보관소에 저장된 MemberDao 이용하기
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@RestController
@RequestMapping("/teacher/")
public class TeacherControl {
  @Autowired
  ServletContext servletContext; // 서블릿 컨텍스트는 아규먼트로 받을 수 없기 때문에, IoC 컨테이너에게서 주입받는다.
  
  @Autowired
  TeacherService teacherService;
  
  int count=0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count);
  }
  
  private List<String> processMultipartFiles(MultipartFile[] files) throws Exception {
    ArrayList<String> photoList = new ArrayList<>();
    for (MultipartFile file : files) {
      if (file.isEmpty())
        continue;
      // 파일이 업로드 되었다면
      String filename = getNewFilename();
      // 임시폴더에 저장되어있는 파일을 /teacher/photo 경로에 옮긴다.
      file.transferTo(new File(servletContext.getRealPath("/teacher/photo/" + filename)));
      photoList.add(filename);
    }
    return photoList;
  }
  
  @RequestMapping("list") // RequestHandler
  public JsonResult list(@RequestParam(defaultValue="1") int pageNo, 
                     @RequestParam(defaultValue="10") int pageSize) throws Exception {
    HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.put("list", teacherService.list(pageNo, pageSize));
    dataMap.put("totalCount", teacherService.getSize());
      return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("add")
  public JsonResult add(Teacher teacher/*, MultipartFile[] photo*/) throws Exception {
//    teacher.setPhotoList(processMultipartFiles(photo));
    teacherService.add(teacher);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("update")
  public JsonResult update(Teacher teacher/*, MultipartFile[] photo*/) throws Exception {
//    teacher.setPhotoList(processMultipartFiles(photo));
    teacherService.update(teacher);
    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("detail")
  public JsonResult detail(int no) throws Exception {
      Teacher teacher = teacherService.get(no);
      if (teacher == null) {
        return new JsonResult(JsonResult.FAIL, no + "번 강사가 없습니다.");
      }
      return new JsonResult(JsonResult.SUCCESS, teacher);
      // 예외 처리는 DispatcherServlet(frontcontroller)에게 맡긴다.
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    teacherService.remove(no);
    return "redirect:list.do";
  }
}


















//