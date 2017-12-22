package ua.com.dudaryk.service.interfaces;

import ua.com.dudaryk.service.transfers.CategoryDTO;

public interface CategoryService {

    CategoryDTO findByDudarykId(Long id);
}
