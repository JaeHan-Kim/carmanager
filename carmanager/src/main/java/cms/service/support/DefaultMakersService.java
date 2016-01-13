package cms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.MakersDao;
import cms.domain.Makers;
import cms.service.MakersService;

@Service
public class DefaultMakersService implements MakersService {
  @Autowired MakersDao makersDao;

  @Override
  public List<Makers> listAll() {
    return makersDao.selectList();
  }
 
}
