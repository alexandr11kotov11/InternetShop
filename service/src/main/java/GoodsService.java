import com.kotov.modelDTO.GoodsDTO;
import javafx.scene.control.Pagination;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

public interface GoodsService {

    @Transactional(readOnly = true)
    List<GoodsDTO> getMainPageProducts();

    @Transactional(readOnly = true)
    List<GoodsDTO> getByPage(int count, Integer page);

    @Transactional(readOnly = true)
    List<GoodsDTO> getByPageAndOrder(int count, Integer page, SortOrder order);

    @Transactional(readOnly = true)
    GoodsDTO getById(long id);

    @Transactional(readOnly = true)
    Pagination getPagination(int itemsPerPage, Integer currentPage);

    @Transactional
    void updateProduct(GoodsDTO product);

    @Transactional
    void addNew(GoodsDTO product);

    @Transactional
    void delete(Long id);


}
