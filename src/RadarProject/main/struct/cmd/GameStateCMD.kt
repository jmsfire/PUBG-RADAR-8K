@file:Suppress("NAME_SHADOWING")
package main.struct.cmd

import com.badlogic.gdx.math.Vector2
import main.GameListener
import main.register
import main.struct.Actor
import main.struct.Bunch
import main.struct.NetGuidCacheObject
import main.struct.cmd.CMD.propertyBool
import main.struct.cmd.CMD.propertyByte
import main.struct.cmd.CMD.propertyFloat
import main.struct.cmd.CMD.propertyInt
import main.struct.cmd.CMD.propertyName
import main.struct.cmd.CMD.propertyObject
import main.struct.cmd.CMD.propertyString
import main.struct.cmd.CMD.propertyVector

object GameStateCMD : GameListener {
    init {
        register(this)
    }

    override fun onGameOver() {
        SafetyZonePosition.setZero()
        SafetyZoneRadius = 0f
        SafetyZoneBeginPosition.setZero()
        SafetyZoneBeginRadius = 0f
        PoisonGasWarningPosition.setZero()
        PoisonGasWarningRadius = 0f
        RedZonePosition.setZero()
        RedZoneRadius = 0f
        TotalWarningDuration = 0f
        ElapsedWarningDuration = 0f
        TotalReleaseDuration = 0f
        ElapsedReleaseDuration = 0f
        NumJoinPlayers = 0
        NumAlivePlayers = 0
        NumAliveTeams = 0
        RemainingTime = 0
        MatchElapsedMinutes = 0
        NumTeams = 0
        IsTeamMatch = false

    }

    var TotalWarningDuration = 0f
    var ElapsedWarningDuration = 0f
    private var RemainingTime = 0
    var MatchElapsedMinutes = 0
    val SafetyZonePosition = Vector2()
    var SafetyZoneRadius = 0f
    private val SafetyZoneBeginPosition = Vector2()
    private var SafetyZoneBeginRadius = 0f
    val PoisonGasWarningPosition = Vector2()
    var PoisonGasWarningRadius = 0f
    val RedZonePosition = Vector2()
    var RedZoneRadius = 0f
    private var TotalReleaseDuration = 0f
    private var ElapsedReleaseDuration = 0f
    private var NumJoinPlayers = 0
    var NumAlivePlayers = 0
    var NumAliveTeams = 0
    var NumTeams = 0
    var IsTeamMatch = false

    fun process(actor: Actor, bunch: Bunch, repObj: NetGuidCacheObject?, waitingHandle: Int, data: HashMap<String, Any?>): Boolean {
        with(bunch) {
            when (waitingHandle) {
                16 -> {
                    val GameModeClass = propertyObject()
                    val b = GameModeClass
                }
                17 -> {
                    val SpectatorClass = propertyObject()
                    val b = SpectatorClass
                }
                18 -> {
                    val bReplicatedHasBegunPlay = propertyBool()
                    val b = bReplicatedHasBegunPlay
                }
                19 -> {
                    val ReplicatedWorldTimeSeconds = propertyFloat()
                    val b = ReplicatedWorldTimeSeconds
                }
                20 -> {
                    val MatchState = propertyName()
                    val b = MatchState
                }
                21 -> {
                    val ElapsedTime = propertyInt()
                    val b = ElapsedTime
                }
                22 -> {
                    val MatchId = propertyString()
                    val b = MatchId
                }
                23 -> {
                    val MatchShortGuid = propertyString()
                    val b = MatchShortGuid
                }
                24 -> propertyBool()//bIsCustomGame
                25 -> propertyBool() //bIsWinnerZombieTeam
                26 -> {
                    val NumTeams = propertyInt()
                    val b = NumTeams
                }
                27 -> {
                    RemainingTime = propertyInt()
                }
                28 -> {
                    MatchElapsedMinutes = propertyInt()
                }
                29 -> {
                    val bTimerPaused = propertyBool()
                    val b = bTimerPaused
                }
//        30->{
//          print("")
//        }
//        31->{
//          print("")
//        }
                32 -> {
                    NumJoinPlayers = propertyInt()
                }
                33 -> {
                    NumAlivePlayers = propertyInt()
//          println(NumAlivePlayers)
                }
                34 -> {
                    val NumAliveZombiePlayers = propertyInt()
                    val b = NumAliveZombiePlayers
                }
                35 -> {
                    NumAliveTeams = propertyInt()
                }
                36 -> {
                    val NumStartPlayers = propertyInt()
                    val b = NumStartPlayers
                }
                37 -> {
                    val NumStartTeams = propertyInt()
                    val b = NumStartTeams
                }
                38 -> {
                    val pos = propertyVector()
                    SafetyZonePosition.set(pos.x, pos.y)
                }
                39 -> {
                    SafetyZoneRadius = propertyFloat()
                }
                40 -> {
                    val pos = propertyVector()
                    PoisonGasWarningPosition.set(pos.x, pos.y)
                }
                41 -> {
                    PoisonGasWarningRadius = propertyFloat()
                }
                42 -> {
                    val pos = propertyVector()
                    RedZonePosition.set(pos.x, pos.y)

                    val b = RedZonePosition
                }
                43 -> {
                    RedZoneRadius = propertyFloat()
                    val b = RedZoneRadius
                }
//        44->{
//
//        }
                45 -> {
                    TotalReleaseDuration = propertyFloat()
                    val b = TotalReleaseDuration
                }
                46 -> {
                    ElapsedReleaseDuration = propertyFloat()
                    val b = ElapsedReleaseDuration
                }
                47 -> {
                    TotalWarningDuration = propertyFloat()
                }
                48 -> {
                    ElapsedWarningDuration = propertyFloat()
                }
                49 -> {
                    val bIsGasRelease = propertyBool()
                }
                50 -> {
                    val bIsTeamMatch = propertyBool()
                    val b = bIsTeamMatch
                }
                51 -> {
                    val bIsZombieMode = propertyBool()
                }
                52 -> {
                    val pos = propertyVector()
                    SafetyZoneBeginPosition.set(pos.x, pos.y)
                }
                53 -> {
                    SafetyZoneBeginRadius = propertyFloat()
                }
                54 -> {
                    val MatchStartType = propertyByte()
                }
                55 -> return false
                else -> return false
            }
            return true
        }
    }
}