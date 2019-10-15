package com.jsimao71.superheros.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import com.jsimao71.superheros.manager.SuperheroManager;
import com.jsimao71.superheros.model.Superhero;
import com.jsimao71.superheros.xmodel.SuperheroFilter;
import com.jsimao71.superheros.xmodel.SuperheroOptions;
import java.util.Collection;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.einnovator.jpa.manager.ManagerBase2;
import org.einnovator.util.PageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping(value = { "/superhero" })
public class SuperheroController extends ControllerBase {

    @Autowired()
    private SuperheroManager superheroManager;

    @GetMapping(value = { "/{id}" })
    public Object show(@PathVariable(value = "id") String id, SuperheroOptions options, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        model.addAttribute("superhero", superheroManager.find(id, options));
        return "superhero/superhero-details";
    }

    @GetMapping(value = {})
    public Object list(SuperheroFilter filter, PageOptions pageOptions, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        model.addAttribute("superheroes", superheroManager.findAll(filter, pageOptions));
        return "superhero/superhero-list";
    }

    @GetMapping(value = { "/create" })
    public Object create(Superhero superhero, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        return "superhero/superhero-editor";
    }

    @PostMapping(value = {})
    public Object createPost(Superhero superhero, BindingResult errors, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        superheroManager.create(superhero);
        return "redirect:/superhero/null";
    }

    @GetMapping(value = { "/{id}/edit" })
    public Object edit(@PathVariable(value = "id") String id, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        return "superhero/superhero-editor";
    }

    @PutMapping(value = { "/{id}" })
    public Object editPost(@PathVariable(value = "id") String id, Superhero superhero, BindingResult errors, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        superheroManager.update(superhero);
        return "redirect:/superhero/" + id;
    }

    @DeleteMapping(value = { "/{id}" })
    public Object delete(@PathVariable(value = "id") String id, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        superheroManager.delete(id);
        return "redirect:/superhero";
    }

    @PostMapping(value = { "/{id}/friend" })
    public Object addFriend(@PathVariable(value = "id") String id, Superhero friend, BindingResult errors, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Superhero superhero = superheroManager.find(id);
        superheroManager.addFriend(superhero, friend);
        return "redirect:/superhero/" + id;
    }

    @ExceptionHandler(value = {})
    public Object error(@PathVariable(value = "exception") Exception exception, Model model, Principal principal, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        return "redirect:/superhero";
    }
}
