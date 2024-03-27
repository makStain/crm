package sprint.project.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sprint.project.crm.model.Requests;
import sprint.project.crm.repository.RequestRepository;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping(value = "/home")
    public String indexPage (Model model) {
        List<Requests> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);
        return "index";
    }

    @PostMapping(value = "/addReq")
    public String addPage(@RequestParam(name = "name") String name,
                         @RequestParam(name = "course") String course,
                         @RequestParam(name = "phone") String phone,
                         @RequestParam(name = "comment") String comment,
                         Model model){
        List<Requests> requests = requestRepository.findAll();
        model.addAttribute("req", requests);
        Requests request = new Requests();
        request.setUserName(name);
        request.setCourseName(course);
        request.setPhone(phone);
        request.setCommentary(comment);
        request.setHandled(true);

        requestRepository.save(request);
        return "redirect:/home";
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id){
        Requests request = requestRepository.findById(id).orElse(null);
        model.addAttribute("reqs", request);
        return "details";
    }

    @GetMapping(value = "/newReq")
    public String newPage(Model model, @PathVariable(name = "id") Long id){
        Requests request = requestRepository.findById(id).orElse(null);
        model.addAttribute("requ", request);
        return "newReq";
    }

    @GetMapping(value = "/newRequest")
    public String newRequest(@RequestParam(name = "id") Long id){

        Requests req = requestRepository.findById(id).orElse(null);

        req.setHandled(true);
        requestRepository.save(req);
        return "redirect:/home";
    }

    @GetMapping(value = "/completeReq")
    public String completePage(Model model, @PathVariable(name = "id") Long id){
        Requests request = requestRepository.findById(id).orElse(null);
        model.addAttribute("reque", request);
        return "completeReq";
    }

    @GetMapping(value = "/completeRequest")
    public String updateRequest(@RequestParam(name = "id") Long id){

        Requests req = requestRepository.findById(id).orElse(null);

        req.setHandled(false);
        requestRepository.save(req);
        return "redirect:/home";
    }

    @PostMapping(value = "/deleteReq")
    public String deleteRequest(@RequestParam(name = "id") Long id){
        requestRepository.deleteById(id);
        return "redirect:/home";
    }
}
