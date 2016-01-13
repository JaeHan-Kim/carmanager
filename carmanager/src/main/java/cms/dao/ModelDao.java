package cms.dao;

import java.util.List;

import cms.domain.Model;

public interface ModelDao {
	public List<Model> selectCarList(int no);

}
