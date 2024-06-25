package com.hutech.quoc.Controller;

import com.hutech.quoc.Entities.Menu;
import com.hutech.quoc.Services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public String getAllMenus(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "menu_list";  // Ensure this matches menu_list.html
    }

    @GetMapping("/create")
    public String createMenuForm(Model model) {
        model.addAttribute("menu", new Menu());
        model.addAttribute("menus", menuService.getAllMenus());
        return "menu_form";  // Ensure this matches menu_form.html
    }

    @GetMapping("/edit/{id}")
    public String editMenuForm(@PathVariable Long id, Model model) {
        Optional<Menu> menu = menuService.getMenuById(id);
        model.addAttribute("menu", menu.orElse(new Menu()));
        model.addAttribute("menus", menuService.getAllMenus());
        return "menu_form";  // Ensure this matches menu_form.html
    }

    @PostMapping("/save")
    public String saveMenu(@ModelAttribute Menu menu) {
        menuService.saveMenu(menu);
        return "redirect:/menus";
    }

    @GetMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return "redirect:/menus";
    }
}