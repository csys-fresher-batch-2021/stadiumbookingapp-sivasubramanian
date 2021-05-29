package in.siva.converter;

import in.siva.dto.MatchDetailsDTO;

import in.siva.model.MatchDetail;

public class MatchDetailConverter {

	private MatchDetailConverter() {

	}

	public static MatchDetail toMatchDetail(MatchDetailsDTO dto) {
		MatchDetail matchDetail = new MatchDetail();
		matchDetail.setStadiumName(dto.getStadiumName());
		matchDetail.setMatchDate(dto.getMatchDate());
		matchDetail.setTeam1(dto.getTeam1());
		matchDetail.setTeam2(dto.getTeam2());
		matchDetail.setAvailableSeats(dto.getAvailableSeats());
		matchDetail.setTotalSeats(dto.getTotalSeats());
		matchDetail.setUpperSeatPrice(dto.getUpperSeatPrice());
		matchDetail.setLowerSeatPrice(dto.getLowerSeatPrice());
		matchDetail.setImage(dto.getImage());
		return matchDetail;
	}
}
