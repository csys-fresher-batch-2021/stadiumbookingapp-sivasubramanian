package in.siva.convertor;

import in.siva.dto.MatchDetailsDTO;

import in.siva.model.MatchDetail;

public class MatchDetailConvertor {

	private MatchDetailConvertor() {

	}

	public static MatchDetail toMatchDetail(MatchDetailsDTO dto) {
		MatchDetail matchDetail = new MatchDetail();
		matchDetail.setStadiumName(dto.getStadiumName());
		matchDetail.setMatchDate(dto.getMatchDate());
		matchDetail.setTeamOne(dto.getTeam1());
		matchDetail.setTeamTwo(dto.getTeam2());
		matchDetail.setAvailableSeats(dto.getAvailableSeats());
		matchDetail.setTotalSeats(dto.getTotalSeats());
		matchDetail.setUpperSeatPrice(dto.getUpperSeatPrice());
		matchDetail.setLowerSeatPrice(dto.getLowerSeatPrice());
		matchDetail.setImage(dto.getImage());
		matchDetail.setMatchTime(dto.getMatchTime());
		return matchDetail;
	}
}
