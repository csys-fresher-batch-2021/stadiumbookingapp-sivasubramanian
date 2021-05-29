package in.siva.dao;

import java.util.List;

import in.siva.exception.DbException;
import in.siva.model.MatchDetail;
import in.siva.model.Seats;

public interface MatchDao {
	public List<MatchDetail> findAllByOrderByDateAsc() throws DbException;
	public List<Seats> findByMatchDate(String stadiumName,String matchDate) throws DbException;

}
