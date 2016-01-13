package cms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.ModelDao;
import cms.domain.Model;
import cms.service.ModelService;

@Service
public class DefaultModelService implements ModelService {
	@Autowired ModelDao modelDao;

	@Override
	public List<Model> carSearch(int no) {
		return modelDao.selectCarList(no);
	}

		
}
