import {React, useEffect, useState} from 'react';
import {MatchDetailsCard} from "../components/MatchDetailsCard";
import {MatchSmallCard} from "../components/MatchSmallCard";

export const TeamPage = () => {

    const [team, setTeam] = useState({matches: []});

    useEffect(
        () => {
            const fetchMatches = async () => {
                const response = await fetch("http://localhost:8080/team/Delhi%20Capitals");
                const data = await response.json();
                setTeam(data);

          };
            fetchMatches();
        }, []

    );

    return (
        <div className="TeamPage">
            <h1>{team.teamName}</h1>
            <MatchDetailsCard />
            <MatchSmallCard />
            <MatchSmallCard />
            <MatchSmallCard />
        </div>
);
}

