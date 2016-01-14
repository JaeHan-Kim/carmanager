package cms.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.dao.OfficialDao;
import cms.domain.Official;
import cms.service.OfficialService;


@Service
public class DefaultOfficialService implements OfficialService {
	@Autowired OfficialDao officialDao;

	@Override
	public Official effiSearch(int no) {
		return officialDao.selectoffiList(no);
	}
		
}
