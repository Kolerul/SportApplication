package com.example.sportapplication.data.util

import com.example.sportapplication.data.model.NetworkCard
import com.example.sportapplication.data.model.NetworkCoach
import com.example.sportapplication.data.model.NetworkCountry
import com.example.sportapplication.data.model.NetworkGoalscorer
import com.example.sportapplication.data.model.NetworkLeague
import com.example.sportapplication.data.model.NetworkLineupList
import com.example.sportapplication.data.model.NetworkLineupPlayer
import com.example.sportapplication.data.model.NetworkLineupTypes
import com.example.sportapplication.data.model.NetworkMatch
import com.example.sportapplication.data.model.NetworkPlayer
import com.example.sportapplication.data.model.NetworkStandingTeam
import com.example.sportapplication.data.model.NetworkStatistic
import com.example.sportapplication.data.model.NetworkSubstitution
import com.example.sportapplication.data.model.NetworkSubstitutionsList
import com.example.sportapplication.data.model.NetworkTeam
import com.example.sportapplication.domain.entity.Card
import com.example.sportapplication.domain.entity.CardInfo
import com.example.sportapplication.domain.entity.Coach
import com.example.sportapplication.domain.entity.Country
import com.example.sportapplication.domain.entity.Goalscorer
import com.example.sportapplication.domain.entity.League
import com.example.sportapplication.domain.entity.LineupList
import com.example.sportapplication.domain.entity.LineupPlayer
import com.example.sportapplication.domain.entity.LineupTypes
import com.example.sportapplication.domain.entity.Match
import com.example.sportapplication.domain.entity.Player
import com.example.sportapplication.domain.entity.StandingTeam
import com.example.sportapplication.domain.entity.Statistic
import com.example.sportapplication.domain.entity.Substitution
import com.example.sportapplication.domain.entity.SubstitutionsList
import com.example.sportapplication.domain.entity.Team

fun toCountry( networkCountry: NetworkCountry): Country =
    Country(
        countryId = networkCountry.countryId,
        countryName = networkCountry.countryName,
        countryLogoUri = networkCountry.countryLogoUri
    )

fun toLeague(networkLeague: NetworkLeague): League =
    League(
        leagueId = networkLeague.leagueId,
        leagueName = networkLeague.leagueName,
        countryId = networkLeague.countryId,
        countryName = networkLeague.countryName,
        countryLogoUri = networkLeague.countryLogoUri,
        leagueSeason = networkLeague.leagueSeason,
        leagueLogoUri = networkLeague.leagueLogoUri
    )

fun toStandingTeam(networkStandingTeam: NetworkStandingTeam): StandingTeam =
    StandingTeam(
        countryName = networkStandingTeam.countryName,
        leagueId = networkStandingTeam.leagueId,
        leagueName = networkStandingTeam.leagueName,
        teamId = networkStandingTeam.teamId,
        teamName = networkStandingTeam.teamName,
        overallPromotion = networkStandingTeam.overallPromotion,
        overallLeaguePosition = networkStandingTeam.overallLeaguePosition,
        overallLeagueMatches = networkStandingTeam.overallLeagueMatches,
        overallLeagueWins = networkStandingTeam.overallLeagueWins,
        overallLeagueDraws = networkStandingTeam.overallLeagueDraws,
        overallLeagueLoses = networkStandingTeam.overallLeagueLoses,
        overallLeagueGoalScored = networkStandingTeam.overallLeagueGoalScored,
        overallLeagueGoalsConceded = networkStandingTeam.overallLeagueGoalsConceded,
        overallLeaguePoints = networkStandingTeam.overallLeaguePoints,
        homeLeaguePosition = networkStandingTeam.homeLeaguePosition,
        homePromotion = networkStandingTeam.homePromotion,
        homeLeagueMatches = networkStandingTeam.homeLeagueMatches,
        homeLeagueWins = networkStandingTeam.homeLeagueWins,
        homeLeagueDraws = networkStandingTeam.homeLeagueDraws,
        homeLeagueLoses = networkStandingTeam.homeLeagueLoses,
        homeLeagueGoalsScored = networkStandingTeam.homeLeagueGoalsScored,
        homeLeagueGoalsConceded = networkStandingTeam.homeLeagueGoalsConceded,
        homeLeaguePoints = networkStandingTeam.homeLeaguePoints,
        awayLeaguePosition = networkStandingTeam.awayLeaguePosition,
        awayPromotion = networkStandingTeam.awayPromotion,
        awayLeagueMatches = networkStandingTeam.awayLeagueMatches,
        awayLeagueWins = networkStandingTeam.awayLeagueWins,
        awayLeagueDraws = networkStandingTeam.awayLeagueDraws,
        awayLeagueLoses = networkStandingTeam.awayLeagueLoses,
        awayLeagueGoalsScored = networkStandingTeam.awayLeagueGoalsScored,
        awayLeagueGoalsConceded = networkStandingTeam.awayLeagueGoalsConceded,
        awayLeaguePoints = networkStandingTeam.awayLeaguePoints,
        leagueRound = networkStandingTeam.leagueRound.toIntOrZero(),
        teamBadgeUri = networkStandingTeam.teamBadgeUri,
        fkStageKey = networkStandingTeam.fkStageKey,
        stageName = networkStandingTeam.stageName,
        )

fun toPlayer(networkPlayer: NetworkPlayer): Player =
    Player(
        playerKey = networkPlayer.playerKey,
        playerId = networkPlayer.playerId.toLongOrZero(),
        playerImageUri = networkPlayer.playerImageUri,
        playerName = networkPlayer.playerName,
        playerNumber = networkPlayer.playerNumber.toIntOrZero(),
        playerCountry = networkPlayer.playerCountry,
        playerType = networkPlayer.playerType,
        playerAge = networkPlayer.playerAge.toIntOrZero(),
        playerMatchPlayed = networkPlayer.playerMatchPlayed.toIntOrZero(),
        playerGoals = networkPlayer.playerGoals.toIntOrZero(),
        playerYellowCards = networkPlayer.playerYellowCards.toIntOrZero(),
        playerRedCards = networkPlayer.playerRedCards.toIntOrZero(),
        playerInjured = networkPlayer.playerInjured,
        playerSubstituteOut = networkPlayer.playerSubstituteOut.toIntOrZero(),
        playerSubstitutesOnBench = networkPlayer.playerSubstitutesOnBench.toIntOrZero(),
        playerAssists = networkPlayer.playerAssists.toIntOrZero(),
        birthDate = networkPlayer.birthDate,
        playerIsCaptain = networkPlayer.playerIsCaptain,
        playerShotsTotal = networkPlayer.playerShotsTotal.toIntOrZero(),
        playerGoalsConceded = networkPlayer.playerGoalsConceded.toIntOrZero(),
        playerFoulsCommitted = networkPlayer.playerFoulsCommitted.toIntOrZero(),
        playerTackles = networkPlayer.playerTackles.toIntOrZero(),
        playerBlocks = networkPlayer.playerBlocks.toIntOrZero(),
        playerCrossesTotal = networkPlayer.playerCrossesTotal.toIntOrZero(),
        playerInterceptions = networkPlayer.playerInterceptions.toIntOrZero(),
        playerClearances = networkPlayer.playerClearances.toIntOrZero(),
        playerDispossesed = networkPlayer.playerDispossesed.toIntOrZero(),
        playerSaves = networkPlayer.playerSaves.toIntOrZero(),
        playerInsideBoxSaves = networkPlayer.playerInsideBoxSaves.toIntOrZero(),
        playerDuelsTotal = networkPlayer.playerDuelsTotal.toIntOrZero(),
        playerDuelsWon = networkPlayer.playerDuelsWon.toIntOrZero(),
        playerDribbleAttempts = networkPlayer.playerDribbleAttempts.toIntOrZero(),
        playerDribbleSucc = networkPlayer.playerDribbleSucc.toIntOrZero(),
        playerPenComm = networkPlayer.playerPenComm.toIntOrZero(),
        playerPenWon = networkPlayer.playerPenWon.toIntOrZero(),
        playerPenScored = networkPlayer.playerPenScored.toIntOrZero(),
        playerPenMissed = networkPlayer.playerPenMissed.toIntOrZero(),
        playerPasses = networkPlayer.playerPasses.toIntOrZero(),
        playerPassesAccuracy = networkPlayer.playerPassesAccuracy.toIntOrZero(),
        playerKeyPasses = networkPlayer.playerKeyPasses.toIntOrZero(),
        playerWoordworks = networkPlayer.playerWoordworks,
        playerRating =  networkPlayer.playerRating
    )

fun toCoach(networkCoach: NetworkCoach): Coach =
    Coach(
        coachName = networkCoach.coachName,
        coachAge = networkCoach.coachAge.toIntOrZero(),
        coachCountry = networkCoach.coachCountry
    )

fun toTeam(networkTeam: NetworkTeam): Team {
    val players = networkTeam.players.map { player ->
        toPlayer(player)
    }

    val coaches = networkTeam.coaches.map { coach ->
        toCoach(coach)
    }

    return Team(
        teamKey = networkTeam.teamKey,
        teamName = networkTeam.teamName,
        teamBadgeUri = networkTeam.teamBadgeUri,
        players = players,
        coaches = coaches
    )
}

fun toCardInfo(networkCard: NetworkCard): CardInfo {
    val isHome = networkCard.homeFault.isNotBlank()
    val card = if(networkCard.card == "yellow card") Card.YELLOW
    else Card.RED
    val playerId = if (isHome) networkCard.homePlayerId
    else networkCard.awayPlayerId
    return CardInfo(
        time = networkCard.time,
        card = card,
        isHomeFault = isHome,
        info = networkCard.info,
        playerId = playerId.toLongOrZero(),
        scoreInfoTime = networkCard.scoreInfoTime
    )
}

fun toGoalscorer(networkGoalscorer: NetworkGoalscorer): Goalscorer {
    val isHome = networkGoalscorer.homeScorer.isNotBlank()
    val scorerName = if (isHome) networkGoalscorer.homeScorer
    else networkGoalscorer.awayScorer
    val assistantName = if (isHome) networkGoalscorer.homeAssist
    else networkGoalscorer.awayAssist
    val scorerId = if (isHome) networkGoalscorer.homeScorerId
    else networkGoalscorer.awayScorerId
    val assistantId = if (isHome) networkGoalscorer.homeAssistId
    else networkGoalscorer.awayAssistId
    return Goalscorer(
        time = networkGoalscorer.time,
        isHome = isHome,
        scorer = scorerName,
        scorerId = scorerId.toLongOrZero(),
        assistant = assistantName,
        assistantId = assistantId.toLongOrZero(),
        score = networkGoalscorer.score,
        info = networkGoalscorer.info,
        scoreInfoTime = networkGoalscorer.scoreInfoTime
    )
}

fun toStatistic(networkStatistic: NetworkStatistic): Statistic =
    Statistic(
        type = networkStatistic.type,
        away = networkStatistic.away,
        home = networkStatistic.home
    )

fun toSubstitution(networkSubstitution: NetworkSubstitution): Substitution =
    Substitution(
        time = networkSubstitution.time,
        substitution = networkSubstitution.substitution,
        substitutionPlayerId = networkSubstitution.substitutionPlayerId
    )

fun toSubstitutionsList(networkSubstitutionsList: NetworkSubstitutionsList): SubstitutionsList{
    val homeList = networkSubstitutionsList.homeList.map { substitution ->
        toSubstitution(substitution)
    }
    val awayList = networkSubstitutionsList.awayList.map { substitution ->
        toSubstitution(substitution)
    }

    return SubstitutionsList(
        homeList,
        awayList
    )
}

fun toLineupPlayer(networkLineupPlayer: NetworkLineupPlayer): LineupPlayer =
    LineupPlayer(
        lineupPlayerName = networkLineupPlayer.lineupPlayer,
        lineupNumber = networkLineupPlayer.lineupNumber.toIntOrZero(),
        lineupPosition = networkLineupPlayer.lineupPosition.toIntOrZero(),
        playerKey = networkLineupPlayer.playerKey
    )

fun toLineupTypes(networkLineupTypes: NetworkLineupTypes): LineupTypes {
    val startingLineups = networkLineupTypes.startingLineups.map {
        toLineupPlayer(it)
    }
    val substitutes = networkLineupTypes.substitutes.map {
        toLineupPlayer(it)
    }
    val coach = networkLineupTypes.coach.map {
        toLineupPlayer(it)
    }
    val missingPlayers = networkLineupTypes.missingPlayers.map {
        toLineupPlayer(it)
    }
    return LineupTypes(
        startingLineups = startingLineups,
        substitutes = substitutes,
        coach = coach,
        missingPlayers = missingPlayers
    )
}

fun toLineupList(networkLineupList: NetworkLineupList): LineupList =
    LineupList(
        home = toLineupTypes(networkLineupList.home),
        away = toLineupTypes(networkLineupList.away)
    )

fun toMatch(networkMatch: NetworkMatch): Match {
    val goalscorer = networkMatch.goalscorers.map {  goalscorer ->
        toGoalscorer(goalscorer)
    }

    val cards = networkMatch.cards.map { card ->
        toCardInfo(card)
    }

    val statistic = networkMatch.statistics.map { statistic ->
        toStatistic(statistic)
    }

    val halfStatistic = networkMatch.statisticsInFirstHalf.map { halfStatistic ->
        toStatistic(halfStatistic)
    }

    return Match(
        matchId = networkMatch.matchId,
        countryId = networkMatch.countryId,
        countryName = networkMatch.countryName,
        leagueId = networkMatch.leagueId,
        leagueName = networkMatch.leagueName,
        matchDate = networkMatch.matchDate,
        matchStatus = networkMatch.matchStatus,
        matchTime = networkMatch.matchTime,
        matchHometeamId = networkMatch.matchHometeamId,
        matchHometeamName = networkMatch.matchHometeamName,
        matchHometeamScore = networkMatch.matchHometeamScore.toIntOrZero(),
        matchAwayteamName = networkMatch.matchAwayteamName,
        matchAwayteamId = networkMatch.matchAwayteamId,
        matchAwayteamScore = networkMatch.matchAwayteamScore.toIntOrZero(),
        matchHometeamHalftimeScore = networkMatch.matchHometeamHalftimeScore.toIntOrZero(),
        matchAwayteamHalftimeScore = networkMatch.matchAwayteamHalftimeScore.toIntOrZero(),
        matchHometeamExtraScore = networkMatch.matchHometeamExtraScore.toIntOrZero(),
        matchAwayteamExtraScore = networkMatch.matchAwayteamExtraScore.toIntOrZero(),
        matchHometeamPenaltyScore = networkMatch.matchHometeamPenaltyScore.toIntOrZero(),
        matchAwayteamPenaltyScore = networkMatch.matchAwayteamPenaltyScore.toIntOrZero(),
        matchHometeamFtScore = networkMatch.matchHometeamFtScore.toIntOrZero(),
        matchAwayteamFtScore = networkMatch.matchAwayteamFtScore.toIntOrZero(),
        matchHometeamSystem = networkMatch.matchHometeamSystem,
        matchAwayteamSystem = networkMatch.matchAwayteamSystem,
        matchLive = networkMatch.matchLive,
        matchRound = networkMatch.matchRound,
        matchStadium = networkMatch.matchStadium,
        matchReferee = networkMatch.matchReferee,
        teamHomeBadgeUri = networkMatch.teamHomeBadgeUri,
        teamAwayBadgeUri = networkMatch.teamAwayBadgeUri,
        leagueLogoUri = networkMatch.leagueLogoUri,
        countryLogoUri = networkMatch.countryLogoUri,
        leagueYear = networkMatch.leagueYear,
        fkStageKey = networkMatch.fkStageKey,
        stageName = networkMatch.stageName,
        goalscorers = goalscorer,
        cards = cards,
        substitutions = toSubstitutionsList(networkMatch.substitutions),
        lineup = toLineupList(networkMatch.lineup),
        statistics = statistic,
        statisticsInFirstHalf = halfStatistic,
    )
}
