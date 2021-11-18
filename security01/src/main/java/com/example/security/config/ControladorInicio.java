package com.example.security.config;

import com.example.security.entity.Post;
import com.example.security.repository.PostRepository;
import com.example.security.service.PostService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PostService postService;
    
    @RequestMapping("/")
    public String mensaje(Model model, @AuthenticationPrincipal User user){
         var posts = postService.readAll();
         log.info("ejecutando el controlador Spring MVC");
         log.info("usuario que hizo login:" + user);
         model.addAttribute("posts", posts);
        return "index";
    }
    @RequestMapping("/posts")
    public String post(Model model){
        model.addAttribute("posts", postService.readAll());
        return "post";
    }
    @RequestMapping("/form")
    public String create(Model model) {
        return "add";
    }
    /*
    @RequestMapping("/add")
    public String guardar(@RequestParam String titulo, @RequestParam String descripcion, Model model) {
        Post post = new Post();
        post.setTitulo(titulo);
        post.setDescripcion(descripcion);
        System.out.println("sout:"+post.getTitulo()+"/"+post.getDescripcion());
        postRepository.save(post);
        return "redirect:/posts";
    }
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") int id) {
        System.out.println("ID: "+id);
        Post post = postRepository.findById(id).orElse(null);
        postRepository.delete(post);

        return "redirect:/posts";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("post", postRepository.findById(id).orElse(null));
        return "edit";
    }
    @RequestMapping("/update")
    public String update(@RequestParam int id, @RequestParam String titulo, @RequestParam String descripcion) {
        Post post = postRepository.findById(id).orElse(null);
        post.setTitulo(titulo);
        post.setDescripcion(descripcion);
        postRepository.save(post);

        return "redirect:/posts";
    }
*/
}
