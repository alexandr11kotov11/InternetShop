import com.kotov.modelDTO.NewsDTO;
import javafx.scene.control.Pagination;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface NewsService {
    @Transactional(readOnly = true)
    List<NewsDTO> getMainPageNews();

    @Transactional(readOnly = true)
    List<NewsDTO> getShortenNewsByPage(int count, Integer page);

    @Transactional(readOnly = true)
    Pagination getPagination(int itemsPerPage, Integer currentPage);

    @Transactional(readOnly = true)
    NewsDTO getById(long id);

    @Transactional(readOnly = true)
    List<NewsDTO> getAll();

    @Transactional
    void addNewComment(String message, Long newsId);

    @Transactional
    void updateNews(NewsDTO pieceOfNews);

    @Transactional
    void addNew(NewsDTO news);

    @Transactional
    void delete(Long id);

    @Transactional
    void deleteComment(Long id);
}
