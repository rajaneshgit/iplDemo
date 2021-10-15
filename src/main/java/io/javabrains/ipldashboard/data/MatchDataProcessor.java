package io.javabrains.ipldashboard.data;
import io.javabrains.ipldashboard.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());
        //set team1 and team2 depending on the inning order
        String firstInningTeam, secondInningTeam;
        if("bat".equalsIgnoreCase(matchInput.getToss_decision())){
            firstInningTeam = matchInput.getToss_winner();
            secondInningTeam = matchInput.getToss_winner().equalsIgnoreCase(matchInput.getTeam1())
                    ?matchInput.getTeam2():matchInput.getTeam1();
        }else{
            firstInningTeam = matchInput.getToss_winner().equalsIgnoreCase(matchInput.getTeam1())
                    ?matchInput.getTeam2():matchInput.getTeam1();
            secondInningTeam = matchInput.getToss_winner();
        }
        match.setTeam1(firstInningTeam);
        match.setTeam2(secondInningTeam);
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setMatchWinner(matchInput.getWinner());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());
        return match;
    }

}
