package in.siva.converter;

import java.util.List;

import in.siva.dto.MatchDTO;
import in.siva.model.Match;

public class MatchConverter {
	
	private MatchConverter() {
		
	}

	public static MatchDTO toMatchDTO(List<Match> match) {
		MatchDTO matchDTO = new MatchDTO();
		matchDTO.setMatchDate(((MatchDTO) match).getMatchDate());
		matchDTO.setAvailableSeate(((MatchDTO) match).getAvailableSeats());
		matchDTO.setBookedSeats(((MatchDTO) match).getBookedSeats());
		return matchDTO;
	}

}
