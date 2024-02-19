package com.example.wishlist.management.Controller;


import com.example.wishlist.management.Model.Item;
import com.example.wishlist.management.Model.dto.ItemDto;
import com.example.wishlist.management.Model.dto.ResponseItemDto;
import com.example.wishlist.management.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class ItemController {

    @Autowired
    private ItemService itemService;

    //Get ALL the Items
    @GetMapping("/wishlist")
    public ResponseEntity<List<ResponseItemDto>> getALLItems()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        // Use the username to fetch the user's wishlist items from the service
        List<ResponseItemDto> items = itemService.getWishlistItems(username);

        return ResponseEntity.ok(items);
    }
    // Add am Item
    @PostMapping("/wishlist")
    public ResponseEntity<String> addAnItem( @RequestBody ItemDto itemDTO)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        try {
            Optional<Item> item = itemService.addItem(username,itemDTO);
            if (item.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong..");
            } else {
                return ResponseEntity.ok(" Item Added Successfully");
            }
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item already exists");
        }
    }
    //Delete an Item
    @DeleteMapping("/wishlist/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id)
    {
        try{
            itemService.deleteItem(id);
            return  new ResponseEntity<>("Item deleted successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error occurred while deleting item", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
