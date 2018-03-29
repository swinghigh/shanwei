package com.dszy.game.gamelogic.majong.shanwei;

import static au.com.ds.ef.FlowBuilder.from;
import static au.com.ds.ef.FlowBuilder.on;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_ADDGANG;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_ANGANG;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_CHI;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_CLEARGANG;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_DINGQUE;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_HU;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_LOOPGANG;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_OUTCARD;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_PENG;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_SELFHU;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_TIANHU;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_TIANHU_DIANPAO;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_TIANTING;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_TING;
import static com.dszy.game.gamelogic.majong.data.Consts.ACTION_TING_INFO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_2TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_2TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_2WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_3TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_3TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_3WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_4TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_4TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_4WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_5TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_5TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_5WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_6TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_6TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_6WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_7TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_7TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_7WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_8TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_8TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_8WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_9TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_9TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_9WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_BAI;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_BEI;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_DONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_FA;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_NAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_NONE;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_XI;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_ZHONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CIRCLEWIND_BEI;
import static com.dszy.game.gamelogic.majong.data.Consts.CIRCLEWIND_DONG;
import static com.dszy.game.gamelogic.majong.data.Consts.DOORWIND_DONG;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_CHUN;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_DONG;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_JU;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_LAN;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_MEI;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_QIU;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_XIA;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_ZHU;
import static com.dszy.game.gamelogic.majong.data.Consts.RESULT_WIN;
import static com.dszy.game.gamelogic.majong.data.Consts.WINTYPE_FLOW;
import static com.dszy.game.gamelogic.majong.data.Consts.WINTYPE_SELF_HU;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.ADDFLOWER;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.ANGANG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.CHI;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.DIANPAO;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.EXECUTE_JIAGANG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.GAMEFLOW;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.JIAGANG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.MINGGANG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.NO;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.NONE;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.PENG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.PLAYCARD;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.START;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.WAIT_HU;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.YES;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.Events.ZIMO;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.AFTER_ANGANG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.AFTER_DIANPAO;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.AFTER_LOOPGANG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.AFTER_MINGGANG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.AFTER_PENG;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.AFTER_ZIMO;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.ASK;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.INIT;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.LOOP_GANG_ASK;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.SETTLE;
import static com.dszy.game.gamelogic.majong.desktop.BaseEnum.States.TURN;
import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dszy.game.conf.UserConst;
import com.dszy.game.entity.UUserInfo;
import com.dszy.game.entity.UUserRecord;
import com.dszy.game.gamelogic.Desk;
import com.dszy.game.gamelogic.GameUserManager;
import com.dszy.game.gamelogic.data.GameUser;
import com.dszy.game.gamelogic.majong.data.Consts;
import com.dszy.game.gamelogic.majong.data.MajongContext;
import com.dszy.game.gamelogic.majong.desktop.BaseEnum;
import com.dszy.game.gamelogic.majong.desktop.BaseFSM;
import com.dszy.game.gamelogic.majong.gameinfo.BaseFlowGameInfo;
import com.dszy.game.gamelogic.majong.logic.BaseLogic;
import com.dszy.game.gamelogic.majong.player.BasePlayer;
import com.dszy.game.gamelogic.majong.player.BasePlayer.Fan;
import com.dszy.game.gamelogic.majong.player.BasePlayer.OpenCard;
import com.dszy.game.gamelogic.majong.shanwei.utils.MjHelper;
import com.dszy.game.gamelogic.majong.utils.Bytes;
import com.dszy.game.gamelogic.majong.utils.ComplexHu.TingPattern;
import com.dszy.game.gamelogic.majong.utils.Copyable;
import com.dszy.game.gamelogic.majong.utils.Hu.TingInfo;
import com.dszy.game.gamelogic.majong.utils.Lists;
import com.dszy.game.gamelogic.majong.utils.Reflections;
import com.dszy.game.log.Logger;
import com.dszy.game.log.LoggerFactory;
import com.dszy.game.message.BaseMsg;
import com.dszy.game.message.proto.game.LeaveStatusMsg;
import com.dszy.game.message.proto.game.MMajongDispenseCardMsg;
import com.dszy.game.message.proto.game.MMajongGameActionMsg;
import com.dszy.game.message.proto.game.MMajongGameOverMsg.Fanma;
import com.dszy.game.message.proto.game.MMajongGameOverMsg.ScoreItem2;
import com.dszy.game.message.proto.game.MMajongGameStartMsg;
import com.dszy.game.message.proto.game.MMajongPressCardMsg;
import com.dszy.game.message.proto.game.MMajongResumeMsg;
import com.dszy.game.message.proto.room.PrivateRoomRankAwardMsg;
import com.dszy.game.message.proto.room.PrivateRoomScorceChangeMsg;
import com.dszy.game.message.proto.room.PrivateRoomScorceChangeMsg.PlayerInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.primitives.Longs;

import au.com.ds.ef.call.ContextHandler;

public class ShanWeiFSM extends BaseFSM {
	
	final static Logger log = LoggerFactory.getLogger(ShanWeiFSM.class);
	
	public static final String SHANWEI = "shanwei";
	protected static final int KEY_EXECUTE_YANGMA=16;
	
	//public static final Boolean isMaiMa = false;
	
	public ShanWeiFSM() {
	}
	
	public ShanWeiFSM(Desk desk) {
		this.desk=desk;
	}
	
	
//	@Override
//	public void onEvent(Object obj) {
//		// TODO Auto-generated method stub
//		super.onEvent(obj);
//	}
	
	
	@Override
	public int resumeGamePlay(long userID, String playID) {
		log.info("playID = " + playID + " resumeGamePlay: userID=" + userID);
		BaseFlowGameInfo gameInfo=getGameInfo();
//		int[] userIDs = gInfo.getAllUserID();
//		BasePlayer player=gameInfo.getPlayer(userID);
		ShanWeiPlayer realPlayer = (ShanWeiPlayer) gameInfo.getPlayer(userID);
		ShanWeiLogic logic=(ShanWeiLogic)getLogic();
		//发送回复对局消息
		ShanWeiMMajongResumeMsg resume = new ShanWeiMMajongResumeMsg();
		resume.setDeskType(desk.getDeskType());
//		resume.setMeIndex(index);
//		resume.setGameID(gInfo.getGameID());
//		resume.setBaseFan(gInfo.getBase());
		resume.setPlayID(playID);
//		resume.setNextUserID(gameInfo.getCurrentPlayer().getUserId());
		resume.setBankUserID(gameInfo.getBanker().getUserId());
		resume.setCloseCards(Lists.trans(realPlayer.getCloseCards()));
		resume.setHuCards(Lists.trans(realPlayer.getHuCards()));
//		resume.setLaizi(gameInfo.getLaizi());
		
		if(gameInfo.getCurrentPlayer()!=null){
			resume.setNextUserID(gameInfo.getCurrentPlayer().getUserId());
		}else{
			resume.setNextUserID(userID);
		}
		resume.setInLoopGang(gameInfo.isInLoopGang());//5.19
		resume.setLastPlayCard(gameInfo.getLastPlayCard());//5.19
//		resume.setFanzi(gameInfo.getFanzi());
//		resume.setPlayTimeOut(getActTimeOut(MJLogic.ACTION_OUTCARD));
//		resume.setActionTimeOut(getActTimeOut(MJLogic.ACTION_HU));
//		resume.setCountHuang(gInfo.getCountZhuang()); // 连庄次数
		resume.setPlayType(gameInfo.getPlayType());
		//resume.setXiapaolist(logic.getXiaPaoList());
		
		resume.setLaZhuangList(logic.getLaZhuangList());
		
		resume.setZuoList(logic.getZuoList());
		resume.setJiaDiList(logic.getDiList());
		resume.setCircleWind(gameInfo.getCircleWind());
		resume.setBankWind(gameInfo.getBanker().getDoorWind());
		resume.setRemainCount(logic.getRemainCount());
//		resume.setBase(gInfo.getBaseCash());
		resume.setPlayNum(gameInfo.getUserCount());
		resume.setFlowerCardsArray(Bytes.trans(gameInfo.getFlowerCards()));
		resume.setIsTing(false);
		resume.setNeedOpenAnGang(gameInfo.isNeedOpenAnGang());
//		if(gameInfo.getCurrentPlayer()!=null){
//			resume.setNextUserID(Ints.checkedCast(gameInfo.getCurrentPlayer().getUserId()));
//		}else{
//			resume.setNextUserID(userID);
//		}
//		resume.setDingQue(gameInfo.isDingque());//定缺
		resume.setInLoopGang(gameInfo.isInLoopGang());//5.19
		resume.setGameStage(gameInfo.getHasHuCount()>0?(byte)1:(byte)0);//0游戏中1已经胡牌
		if(gameInfo.isInLoopGang()){//5.19
			realPlayer.setResumeInLoopGang(true);
		}
		for (int i = 0; i < gameInfo.getUserCount(); i++) {
			ShanWeiPlayer p=(ShanWeiPlayer)gameInfo.getPlayers().get(i);
			if(p.getUserId()==userID && p.getActions().contains(ACTION_OUTCARD)){
				resume.setDoorCard(p.getDoorCard());
			}
			long uid = p.getUserId();
			GameUser user = GameUserManager.getUser(uid);
			if(user==null){
				log.info("{} resume but gameuser {} is still null!!!!",playID,uid);
			}
			UUserInfo info = GameUserManager.getUserInfo(uid);
//			UUserPoint point = GameUserManager.getUserPointInfo(uid);
			UUserRecord uRecord = GameUserManager.getUserRecordInfo(uid, desk.getGameId());
			MMajongResumeMsg.GameUserInfo sItem = new MMajongResumeMsg.GameUserInfo();
			
			{//6.23
				if(user.getUserId()==userID){
					user.setStauts(UserConst.PLAYING);
					user.save();
				}
//				sItem.setUserStatus(user.isOnline()?1:0);
				sItem.setOnLine(user.isOnline());
			}
			
			sItem.setUserID(uid);
			sItem.setXiapaoNum(p.getPao());
			if(p==gameInfo.getBanker()){
				sItem.setZuoNum(p.getZuo());
			}else{
				sItem.setLaZhuangNum(p.getLa());
			}
			sItem.setJiadi(p.getDi());
			sItem.setNickName(info.getNickName());
			sItem.setSex(info.getSex());
			sItem.setIconID(info.getImgId());
			sItem.setUserGrade(null != uRecord ? uRecord.getLevel() : 0);
			sItem.setJingDu(user.getLongitude());// 写入经纬度
			sItem.setWeiDu(user.getLatitude());// 写入经纬度
			sItem.setIpAddress(user.getIP());
			sItem.setMoney(p.getScore());
			sItem.setCardNum(p.getCloseCards().size());
			sItem.setFlowerCards(Lists.trans(p.getFlowerCards()));
			sItem.setDoorWinds(p.getDoorWind());
			sItem.setDisCard(Lists.trans(p.getPlayCards()));
			sItem.setTingstatus(p.isTing()?1:0);
			byte[] opc=new byte[0];
			byte[] opcac=new byte[0];
			byte[] opct=new byte[0];
			long[] opcui=new long[0];
			List<OpenCard> openCards=p.getOpenCards();
			for(OpenCard openCard:openCards){
				opc=Bytes.concat(opc, openCard.getOpenCards().get(0));
				opcac=Bytes.concat(opcac, openCard.getOpenCardsOrig());
				opct=Bytes.concat(opct, openCard.getOpenCardsType());
				opcui=Longs.concat(opcui, new long[]{openCard.getOpenCardsUserID()});
			}
			sItem.setOpenCards(opc);
			sItem.setOpenCardsActCard(opcac);
			sItem.setOpenCardsType(opct);
			sItem.setOpenCardUserId(opcui);
			resume.addUserInfoItems(sItem);
		}
		resume.setActions(Lists.trans(realPlayer.getActions()));
//		if (gameInfo.getNextPlayer().getUserId() == userID) {
//			resume.setActionCard(gameInfo.getLastPlayCard());
//			resume.setDoorCard(player.getDoorCard());
//		}
		List<Byte> actions=realPlayer.getActions();
		if(actions.contains(ACTION_ADDGANG)){
			resume.setAddGangCards(Lists.trans(realPlayer.getAddGangCards()));
		}
		if(actions.contains(ACTION_ANGANG)){
			resume.setAnGangCards(Lists.trans(realPlayer.getAnGangCards()));
		}
		if(actions.contains(Constants.ACTION_ID_YANGMA)){
			resume.setYangMC(Lists.trans(realPlayer.getNoFeeGangCards()));
		}
//		if(actions.contains(ACTION_CHI)){
//			resume.setChiCards(player.getChiCards());
//		}
		
//		if(actions.contains(ACTION_TING) || actions.contains(ACTION_TIANTING)){
//			List<TingPattern> tingPatterns=realPlayer.getTingPatterns();
//			if(!tingPatterns.isEmpty()){//5.5 听牌提示恢复对局
//				if(!(actions.contains(ACTION_TING) || actions.contains(ACTION_TIANTING))){
////					actions.add(ACTION_TING_INFO);
//					byte[] actionArray=resume.getActions();
//					resume.setActions(Bytes.concat(actionArray,ACTION_TING_INFO));
//				}
//			}
			List<TingInfo> tingInfos= realPlayer.getTingInfos();
			if(!tingInfos.isEmpty()){//5.5 听牌提示恢复对局
				if(!(actions.contains(ACTION_TING) || actions.contains(ACTION_TIANTING))){
//					actions.add(ACTION_TING_INFO);
					byte[] actionArray=resume.getActions();
					resume.setActions(Bytes.concat(actionArray,ACTION_TING_INFO));
				}
			}
			List<Byte> playForTingCards=new ArrayList<>();
			List<List<Byte>> tingHuCards=new ArrayList<>();
//			for(TingPattern tingPattern:tingPatterns){
//				playForTingCards.add(tingPattern.getPlayCard());
//				tingHuCards.add(new ArrayList<>(tingPattern.getTingCards()));
//			}
			
			for (TingInfo info : tingInfos) {
				tingHuCards.add(info.getTingCards());
				playForTingCards.add(info.getPlayForTingCard());
			}
			
			resume.setTingCards(Bytes.trans(playForTingCards));
//			pressCard.setPlayForTingCards(playForTingCards);
			resume.setTingHuCards(tingHuCards);
//		}
		sendMessageToPlayerOne(realPlayer, resume);
		
		// 改玩家状态广播给其他人
		LeaveStatusMsg lsmsg = new LeaveStatusMsg();
		lsmsg.setLeaveStatus(0);
		lsmsg.setPlayerId(userID);
		sendMessageToPlayer(Lists.make(realPlayer), lsmsg);

		log.info("resumeGamePlay(), playID = " + playID + " playID end");
		return 0;
	}
	
	protected void initFlow(){
		flow =
	            from(INIT).transit(
	        		true,//<=这里设置true是因为补花流程有循环圈，设置true跳过循环validation
        				on(START).to(TURN).transit(
        						/*on(getEvent(Constants.YANGMA_EVENT)).to(getState(Constants.YANGMA_STATE)).transit(
    								on(NO).to(TURN),
    								on(YES).to(TURN)
    								),// 添加*/
        	            		on(ADDFLOWER).to(TURN),  //<=这里加了补花流程
        	    				on(PLAYCARD).to(ASK).transit(
        							on(PENG).to(AFTER_PENG).transit(
        								on(NO).to(ASK),
        								on(YES).to(TURN)
        							),
        							on(MINGGANG).to(AFTER_MINGGANG).transit(
        									on(NO).to(ASK),
        									on(YES).to(TURN)
        							),
        							on(DIANPAO).to(AFTER_DIANPAO).transit(
        								on(NO).to(ASK),
        								on(WAIT_HU).to(ASK),
        								on(YES).finish(SETTLE)
        							),
        							on(NONE).to(TURN)
        						),
        	    				on(JIAGANG).to(LOOP_GANG_ASK).transit(
        							on(NO).to(TURN),
        							on(EXECUTE_JIAGANG).to(TURN),
        							on(DIANPAO).to(AFTER_LOOPGANG).transit(
        								on(NO).to(LOOP_GANG_ASK),
        								on(WAIT_HU).to(LOOP_GANG_ASK),
        								on(YES).finish(SETTLE)
        							)
        						),
        	    				
        	    				on(getEvent(Constants.YANGMA_EVENT)).to(LOOP_GANG_ASK).transit(
        								on(NO).to(TURN),
//        								on(getEvent(Constants.EXECUTE_YANGMA)).to(TURN),
        								on(EXECUTE_JIAGANG).to(TURN),
        								on(DIANPAO).to(AFTER_LOOPGANG).transit(
                								on(NO).to(LOOP_GANG_ASK),
                								on(WAIT_HU).to(LOOP_GANG_ASK),
                								on(YES).finish(SETTLE)
                							)
        								),// 添加
        	    				
        	    				on(ANGANG).to(AFTER_ANGANG).transit(
        							on(NO).to(TURN),
        							on(YES).to(TURN)
        						),
        	    				on(ZIMO).to(AFTER_ZIMO).transit(
        							on(NO).to(TURN),
        							on(YES).finish(SETTLE)
        						),
        	    				//on(TING).to(TURN),//<=加了听事件
        	    				on(GAMEFLOW).finish(SETTLE)
        	        		)
	            );
	}
	
	@Override
	protected void initEvents(){
		addEvent(Constants.YANGMA_EVENT);
		addEvent(Constants.EXECUTE_YANGMA);
	}
	
	@Override
	protected void initStates() {
		addState(Constants.YANGMA_STATE);
	}
	
	@Override
	protected void bindEvents() {
		events=new HashMap<>();
		context.setEvents(events);
		events.put((int) ACTION_OUTCARD, PLAYCARD);
		events.put((int) ACTION_CHI, CHI);
		events.put((int) ACTION_PENG, PENG);
		events.put((int) ACTION_CLEARGANG, MINGGANG);
		events.put((int) ACTION_ADDGANG, JIAGANG);
		events.put((int) ACTION_ANGANG, ANGANG);
		events.put((int) ACTION_HU, DIANPAO);
		events.put((int) ACTION_TIANHU_DIANPAO, DIANPAO);
		events.put((int) Constants.ACTION_DIHU_DIANPAO, DIANPAO);//地胡：点炮
		events.put((int) ACTION_SELFHU, ZIMO);
		events.put((int) ACTION_TIANHU, ZIMO);
		events.put((int) ACTION_TING,BaseEnum.Events.TING);
		events.put((int) ACTION_TIANTING,BaseEnum.Events.TING);
		events.put((int) ACTION_DINGQUE,BaseEnum.Events.DINGQUE);
		events.put((int) Constants.ACTION_DIHU, ZIMO);//地胡：自摸
		events.put((int) Constants.ACTION_ID_YANGMA,getEvent(Constants.YANGMA_EVENT));
		
        events.put((int) ACTION_LOOPGANG,DIANPAO);//edit 抢杠
	}
	
	public void bindFlow() {
		super.bindFlow();
		flow.trace().whenEnter(INIT, init()) // 初始化牌局
				.whenEnter(TURN, moCark()) // 摸牌的--状态
				.whenEvent(PLAYCARD, preCard()) // 出一张牌--事件
				.whenEvent(ADDFLOWER, addflower()) // 补花
				.whenEvent(getEvent(Constants.YANGMA_EVENT), yangMaAction()) // 养马--事件
//				.whenEvent(getEvent(Constants.EXECUTE_YANGMA), yangMaAction()) // 养马--事件
//				.whenEnter(getState(Constants.YANGMA_STATE), yangMaAftAction())// 养马 --状态
				.whenEnter(ASK, askAction()) // 询问特殊操作--状态
//				.whenEvent(CHI, chiAction()) // 有吃的--事件
				.whenEvent(PENG, pengAction()) // 有碰的--事件
				.whenEnter(AFTER_PENG, pengAftAction())// 正在碰的 --状态
				.whenEvent(MINGGANG, clearGangAction())// 有明杠的 --事件
				.whenEnter(AFTER_MINGGANG, clearGangAftAction())// 正在明杠的 --状态
				.whenEvent(DIANPAO, dianPaoHuAction())// 有点炮胡的 --事件
				.whenEnter(AFTER_DIANPAO, dianPaoHuAftAction())// 确认点炮胡后的 --状态
				.whenEvent(JIAGANG, addGangAction())// 有加杠的 --事件
				.whenEnter(LOOP_GANG_ASK, loopGangAsk())// 检查抢杠胡的 --状态
				.whenEnter(AFTER_LOOPGANG, after_loopgang())// 确认有抢杠胡正进行询问的--状态
				.whenEvent(EXECUTE_JIAGANG, addGangExecute())// 确认进行加杠的 --事件
				.whenEvent(ANGANG, anGangAction())// 可以暗杠的 --事件
				.whenEnter(AFTER_ANGANG, anGangExecute())// 正在暗杠的 --状态
				.whenEvent(ZIMO, selfHuAction())// 可以自摸的 --事件
				.whenEnter(AFTER_ZIMO, selfHuExecute())// 确认自摸的 --状态
				.whenEnter(SETTLE, settleAction())// 游戏结束，结算中的 --状态
//				.whenError(new ExecutionErrorHandler<MajongContext>() {
//					@Override
//					public void call(ExecutionError error, MajongContext context) {
//						log.error(Utils.getExceptionTrace(error));
//					}
//				})
				;
	}
	

	public ContextHandler<MajongContext> addflower() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				List<BasePlayer> actionPlayers=getGameInfo().getActionPlayers();
				BaseLogic logic=getLogic();
				checkArgument(actionPlayers.size()==1, "actionPlayers: "+actionPlayers);
				BasePlayer player=actionPlayers.get(0);
				MMajongGameActionMsg action= new MMajongGameActionMsg();
				List<Byte> closeCards=player.getCloseCards();
				for (int i=0;i<closeCards.size();i++) {
					byte card=closeCards.get(i);
					if (logic.isFlower(player,card)) {
						byte addCard=logic.drawCard();
						if(addCard==CARD_NONE){
//							context.getExtraData().put(KEY_WINTYPE, WINTYPE_FLOW);
//							context.trigger(流局);
							context.setSignal(KEY_NEED_DRAW_CARD, true);
							return;
						}else{
							closeCards.set(i, addCard);i--;
							player.getFlowerCards().add(card);
							player.setDoorCard(addCard);
							action.setActionID(Consts.ACTION_ADDFLOWER);
							action.setCard(addCard);
							action.setActionCard(card);
							action.setUserID(player.getUserId());
							//听牌状态
							{//7.4
//								if(logic.canHu(player,CARD_NONE) || logic.canAddGang(player) || logic.canAnGang(player) || (!player.isTing() && logic.canTing(player))){
//									action.setHasAction(true);
//								}
								
								if(logic.getMinRemainCount() >= logic.getRemainCount()){
									action.setHasAction(true);
								}else{
									if(logic.canHu(player,CARD_NONE) || logic.canAddGang(player) || logic.canAnGang(player) || (!player.isTing() && logic.canTing(player))){
										action.setHasAction(true);
									}
								}
								
							}
							sendMessageToPlayer(Lists.emptyList(), action);
						}
					}
				}
				Collections.sort(closeCards);
				context.setSignal(KEY_NEED_DRAW_CARD, false);
				context.setSignal(KEY_AFTER_ADDFLOWER, true);
				context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());
			}
		};
	}

	public ContextHandler<MajongContext> selfHuExecute() {
		return new ContextHandler<MajongContext>() {
			@Override
			public void call(MajongContext context) throws Exception {
				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				int actionResult = action.getActionResult();
				BasePlayer player=getGameInfo().getPlayer(action.getUserID());
				getGameInfo().getActionPlayers().add(player);
				if(actionResult==0){
					context.setSignal(KEY_NEED_DRAW_CARD, false);
					context.setSignal(KEY_DROP_SELFHU, true);
//					context.setSignal(KEY_NEED_HINT_ACTION, false);
					context.trigger(NO);
				}else{
					context.setSignal(KEY_WINTYPE, WINTYPE_SELF_HU);
					context.trigger(YES);
				}
			}
		};
	}

	public ContextHandler<MajongContext> selfHuAction() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 自摸:" + action+" start");
				long inUserID = action.getUserID();
				int actionResult = action.getActionResult();
				int actionID = action.getActionID();
				byte actionCard = action.getActionCard();
				byte[] cbCards = action.getCbCards();
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getPlayer(inUserID);
				List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
				checkArgument(actionPlayers.contains(player),"ActionPlayers: "+actionPlayers);
				player.getActions().clear();
				actionPlayers.remove(player);
				if (actionResult == 0) {
					((ShanWeiPlayer) player).setCanqihuahu(false);
				} else {
					MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
					sendAction.setUserID(inUserID);
					sendAction.setActionID(actionID);
					sendAction.setActionResult(actionResult);
					sendAction.setActionCard(actionCard);
					sendAction.setCbCards(cbCards);
					sendAction.setServertime(System.currentTimeMillis());
					sendMessageToPlayer(Lists.emptyList(), sendAction);
					
					if(player.isCanTianHu()) player.setTianHu(true);
					System.out.println(player.isTianHu()+"/--------------");
					gameInfo.setCanHuCount(gameInfo.getCanHuCount()-1);
					gameInfo.setHasHuCount(gameInfo.getHasHuCount()+1);;
					gameInfo.getWinners().add(player);
				}
				log.info("playID  = " + playID + " 自摸:" + action+" end");
			
			}
		};
	}

	public ContextHandler<MajongContext> anGangAction() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 暗杠:" + action+" start");
				long inUserID = action.getUserID();
				int actionResult = action.getActionResult();
				int actionID = action.getActionID();
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getPlayer(inUserID);
				List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
				checkArgument(actionPlayers.contains(player),"ActionPlayers: "+actionPlayers);
				player.getActions().clear();
				gameInfo.getActionPlayers().remove(player);
				if (actionResult == 0) {
				}
				else{
					byte actionCard = action.getActionCard();
					byte[] cbCards = action.getCbCards();
					gameInfo.setGangCount(gameInfo.getGangCount()+1);
					player.setAnGangCount(player.getAnGangCount()+1);;
					Byte temp=Byte.valueOf(actionCard);
					player.getCloseCards().remove(temp);
					player.getCloseCards().remove(temp);
					player.getCloseCards().remove(temp);
					player.getCloseCards().remove(temp);
					OpenCard openCard=new OpenCard(
							Lists.make(temp,temp,temp,temp), 
							temp, 
							ACTION_ANGANG, 
							inUserID);
					player.getOpenCards().add(openCard);
					
					//暗杠不能七花胡
					if (player.getFlowerCards().size()>=7 && ((ShanWeiPlayer) player).isCanqihuahu()) {
						((ShanWeiPlayer) player).setCanqihuahu(false);
					}
					
					// 杠后不能天胡
					for(BasePlayer player2 :gameInfo.getPlayers()) {
						player2.setCanTianHu(false);
					}
					
//					player.setCanTianHu(false);
					
					MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
					sendAction.setUserID(inUserID);
					sendAction.setActionID(actionID);
					sendAction.setActionResult(actionResult);
					sendAction.setActionCard(actionCard);
					sendAction.setCbCards(cbCards);
					sendAction.setServertime(System.currentTimeMillis());
					sendMessageToPlayer(Lists.emptyList(), sendAction);
					
					if(gameInfo.isGang()) gameInfo.setGangOnGang(true);
					gameInfo.setGang(true);
				}
				log.info("playID  = " + playID + " 暗杠:" + action+" end");
			
			}
		};
	}

	public ContextHandler<MajongContext> after_loopgang() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {
				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				long inUserId=action.getUserID();
				boolean multiHu=getLogic().isSuportMutiHu();
				byte lastPlayerCard=getGameInfo().getLastPlayCard();//补杠牌
				BasePlayer lastPlayer=getGameInfo().getLastPlayer();//补杠者
				BasePlayer actionPlayer=getGameInfo().getPlayer(inUserId);
				
				//是否牌局结束
				boolean isOver=false;
				if(multiHu){
					if(gameInfo.getCanHuCount()==0 && gameInfo.getHasHuCount()>0){
						isOver=true;
					}
				}else{
					//不能一炮多响，一家胡牌，马上结算
					if(gameInfo.getHasHuCount()>0){
						isOver=true;
					}
				}
				if(isOver){
					gameInfo.setLoopGang(true);
//					context.setSignal(KEY_WINTYPE, WINTYPE_HU);
					context.setSignal(KEY_WINTYPE, Consts.WINTYPE_LOOP_GANG);
					context.trigger(YES);
				}else{
					List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
					boolean hasHu=false;
					if(multiHu){
						if(gameInfo.getCanHuCount()>0){
							hasHu=true;
						}
					}else{
						BasePlayer downPlayer=getGameInfo().getDownPlayer(actionPlayer);
						while(!downPlayer.equals(lastPlayer)){
							List<BasePlayer> ret=checkAction(lastPlayerCard, Lists.make(downPlayer), true, false, false);
							if(ret.isEmpty()){
								downPlayer=getGameInfo().getDownPlayer(downPlayer);
							}else{
								checkArgument(actionPlayers.isEmpty(), "actionPlayers: "+actionPlayers);
								actionPlayers.addAll(ret);
								hasHu=true;
								break;
							}
						}
					}
					if(hasHu){
						context.setSignal(KEY_NEED_HINT_ACTION, !multiHu);//一炮多响不需要重复提示胡牌
						context.trigger(WAIT_HU);
					}else{
						context.setSignal(KEY_EXECUTE_JIAGANG, true);
						context.trigger(NO);
					}
				}
			}
		};
	}

	public ContextHandler<MajongContext> dianPaoHuAftAction() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				long inUserId=action.getUserID();
				boolean multiHu=getLogic().isSuportMutiHu();
				byte lastPlayerCard=getGameInfo().getLastPlayCard();//放炮牌
				BasePlayer lastPlayer=getGameInfo().getLastPlayer();//放炮者
				BasePlayer actionPlayer=getGameInfo().getPlayer(inUserId);
				//是否牌局结束
				boolean isOver=false;
				if(multiHu){
					if(gameInfo.getCanHuCount()==0 && gameInfo.getHasHuCount()>0){
						isOver=true;
					}
				}else{
					//不能一炮多响，一家胡牌，马上结算
					if(gameInfo.getHasHuCount()>0){
						isOver=true;
					}
				}
				if(isOver){
					context.setSignal(KEY_WINTYPE, Consts.WINTYPE_HU);
					context.trigger(YES);
				}else{
					List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
					boolean hasHu=false;
					if(multiHu){
						if(gameInfo.getCanHuCount()>0){
							hasHu=true;
						}
					}else{
						BasePlayer downPlayer=getGameInfo().getDownPlayer(actionPlayer);
						while(!downPlayer.equals(lastPlayer)){
							List<BasePlayer> ret=checkAction(lastPlayerCard, Lists.make(downPlayer), true, false, false);
							if(ret.isEmpty()){
								downPlayer=getGameInfo().getDownPlayer(downPlayer);
							}else{
								checkArgument(actionPlayers.isEmpty(), "actionPlayers: "+actionPlayers);
								actionPlayers.addAll(ret);
								hasHu=true;
								break;
							}
						}
					}
					if(hasHu){
						context.setSignal(KEY_NEED_HINT_ACTION, !multiHu);//一炮多响不需要重复提示胡牌
						context.trigger(WAIT_HU);
					}else{
						List<BasePlayer> tempList=Lists.circleList(getGameInfo().getPlayers(), lastPlayer);
						tempList.remove(lastPlayer);
						checkArgument(actionPlayers.isEmpty(), "actionPlayers: "+actionPlayers);
						actionPlayers.addAll(checkAction(lastPlayerCard, tempList, false, true, true));
						if(gameInfo.isGang()){
							gameInfo.setGang(false);
							gameInfo.setGangOnGang(false);
						}
						context.setSignal(KEY_NEED_HINT_ACTION, true);
						context.trigger(NO);
					}
				}
			
			}
		};
	}

	public ContextHandler<MajongContext> dianPaoHuAction() {
		return new ContextHandler<MajongContext>() {
			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 点炮胡:" + action+" start");
				long inUserID = action.getUserID();
				int actionResult = action.getActionResult();
				int actionID = action.getActionID();
				byte actionCard = action.getActionCard();
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getPlayer(inUserID);
				checkArgument(gameInfo.getActionPlayers().contains(player),"ActionPlayers: "+gameInfo.getActionPlayers());
				player.getActions().clear();
				gameInfo.getActionPlayers().remove(player);
				gameInfo.setCanHuCount(gameInfo.getCanHuCount()-1);;
				if (actionResult == 0) {
					player.getCannotHuCard().add(actionCard);
					player.setCanHu(false);
				} else {
					MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
					sendAction.setUserID(inUserID);
					sendAction.setActionID(actionID);
					sendAction.setActionResult(actionResult);
					sendAction.setActionCard(actionCard);
					sendAction.setLastPlayUserID(gameInfo.getLastPlayer().getUserId());
					sendAction.setServertime(System.currentTimeMillis());
					sendMessageToPlayer(Lists.emptyList(), sendAction);
					
					gameInfo.setHasHuCount(gameInfo.getHasHuCount()+1);;
					gameInfo.getWinners().add(player);
				}
				log.info("playID  = " + playID + " 点炮胡:" + action+" end");
			
			}
		};
	}

	public ContextHandler<MajongContext> addGangAction() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 加杠:" + action+" start");
				long inUserID = action.getUserID();
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getPlayer(inUserID);
				List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
				checkArgument(actionPlayers.contains(player),"ActionPlayers: "+ actionPlayers);
				checkArgument(player.getActions().contains(ACTION_ADDGANG),"Actions: "+ player.getActions());
				context.setSignal(KEY_EXECUTE_JIAGANG, false);
				context.setSignal(KEY_FIRST_JIAGANG_ASK, true);
				if(action.getActionResult()==1){//5.19
					gameInfo.setInLoopGang(true);
					player.getCloseCards().remove(Byte.valueOf(action.getActionCard()));
					
					// 杠后不能天胡
					for(BasePlayer player2 :gameInfo.getPlayers()) {
						player2.setCanTianHu(false);
					}
					
				}
				log.info("playID  = " + playID + " 加杠:" + action+" end");
			
			}
		};
	}

	private ContextHandler<MajongContext> clearGangAftAction() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				int actionResult = action.getActionResult();
				BasePlayer player=getGameInfo().getPlayer(action.getUserID());
				if(actionResult==0){
					boolean canChi=player.getActions().contains(ACTION_CHI);
					player.getActions().clear();
					byte lastPlayerCard=getGameInfo().getLastPlayCard();
					BasePlayer lastPlayer=getGameInfo().getLastPlayer();
					BasePlayer downPlayer=getGameInfo().getDownPlayer(lastPlayer);
					getGameInfo().getActionPlayers().addAll(checkAction(lastPlayerCard, Lists.make(downPlayer), false, false, !canChi));
					context.setSignal(KEY_NEED_HINT_ACTION, true);
					context.trigger(NO);
				}else{
					ShanWeiGameInfo shanWeiGameInfo=(ShanWeiGameInfo)getGameInfo();
					shanWeiGameInfo.setCanHuDiHu(false);//有碰杠，牌局不能在胡地胡
					getGameInfo().getActionPlayers().add(player);
					context.setSignal(KEY_NEED_DRAW_CARD, true);
					context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());
					context.trigger(YES);
				}
			
			}
		};
	}

	public ContextHandler<MajongContext> clearGangAction() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 明杠:" + action+" start");
				long inUserID = action.getUserID();
				int actionResult = action.getActionResult();
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getPlayer(inUserID);
				checkArgument(gameInfo.getActionPlayers().contains(player),"ActionPlayers: "+ gameInfo.getActionPlayers());
				BasePlayer lastPlayer=gameInfo.getLastPlayer();
				boolean canChi=player.getActions().contains(ACTION_CHI);
				player.getActions().clear();
				gameInfo.getActionPlayers().remove(player);
				if (actionResult == 0) {
					if(canChi) player.getActions().add(ACTION_CHI);
				}
				else{
					int actionID = action.getActionID();
					byte actionCard = gameInfo.getLastPlayCard();
					gameInfo.setGangCount(gameInfo.getGangCount()+1);;
					player.setClearGangCount(player.getClearGangCount()+1);;
					Byte temp=Byte.valueOf(actionCard);
					byte[] cbCards=new byte[]{actionCard,actionCard,actionCard,actionCard};
					lastPlayer.getPlayCards().remove(lastPlayer.getPlayCards().size()-1);
					player.getCloseCards().remove(temp);
					player.getCloseCards().remove(temp);
					player.getCloseCards().remove(temp);
					gameInfo.getDisCards().remove(gameInfo.getDisCards().size()-1);
					
					OpenCard openCard=new OpenCard(
							Lists.make(temp,temp,temp,temp), 
							temp, 
							ACTION_CLEARGANG, 
							lastPlayer.getUserId());
					player.getOpenCards().add(openCard);
					
					// 杠后不能天胡
					for(BasePlayer player2 :gameInfo.getPlayers()) {
						player2.setCanTianHu(false);
					}
					
					MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
					sendAction.setUserID(inUserID);
					sendAction.setActionID(actionID);
					sendAction.setActionResult(actionResult);
					sendAction.setActionCard(actionCard);
					sendAction.setCbCards(cbCards);
					sendAction.setLastPlayUserID(lastPlayer.getUserId());
					sendAction.setServertime(System.currentTimeMillis());
					sendMessageToPlayer(Lists.emptyList(), sendAction);
					
					if(gameInfo.isGang()) gameInfo.setGangOnGang(true);
					gameInfo.setGang(true);
				}
				log.info("playID  = " + playID + " 明杠:" + action+" end");
			
			}
		};
	}

	public ContextHandler<MajongContext> askAction() {
		return new ContextHandler<MajongContext>() {
			
			@Override
			public void call(MajongContext context) throws Exception {
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
				if(actionPlayers.isEmpty()){
					BasePlayer lastPlayer=gameInfo.getLastPlayer();
					BasePlayer downPlayer=gameInfo.getDownPlayer(lastPlayer);
					actionPlayers.add(downPlayer);
					context.setSignal(KEY_NEED_DRAW_CARD, true);
					context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());
					context.trigger(NONE);
				}else{
					boolean needHintAction=context.getSignal(KEY_NEED_HINT_ACTION,false);
					if(needHintAction){
						for(BasePlayer p:actionPlayers){
							MMajongPressCardMsg pressCard = new MMajongPressCardMsg();
							pressCard.setPlayID(playID);
							pressCard.setServertime(System.currentTimeMillis());
							pressCard.setActionCard(gameInfo.getLastPlayCard());
							if(p.getActions().contains(ACTION_CHI)){
								pressCard.setChiCards(p.getChiCards());
							}
							if (p.getActions().size()>0) {
								pressCard.setActions(Lists.trans(p.getActions())); // 设置用户特殊操作参数
								pressCard.setNextPlayer(p.getUserId()); // 设置用户特殊操作参数
								log.debug("playID=" + playID + ",hint action: " + pressCard);
								sendMessageToPlayerOne(p, pressCard);
							}
						}
					}
				}	
			}
		};
	}

	public ContextHandler<MajongContext> yangMaAction() {
		return new ContextHandler<MajongContext>() {
			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 养马:" + action+" start");
				long inUserID = action.getUserID();
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getPlayer(inUserID);
				
				List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
				checkArgument(actionPlayers.contains(player),"ActionPlayers: "+ actionPlayers);
				checkArgument(player.getActions().contains(Constants.ACTION_ID_YANGMA),"Actions: "+ player.getActions());
				context.setSignal(KEY_EXECUTE_JIAGANG, false);
//				context.setSignal(KEY_EXECUTE_YANGMA, true);
//				context.setSignal(KEY_NEED_HINT_ACTION, false);
				context.setSignal(KEY_FIRST_JIAGANG_ASK, true);
//				context.setSignal(KEY_NEED_DRAW_CARD, true);
				if(action.getActionResult()==1){//5.19
					gameInfo.setInLoopGang(true);
					player.getCloseCards().remove(Byte.valueOf(action.getActionCard()));
					
					Iterator it = ((ShanWeiPlayer)player).getNoFeeGangCards().iterator();
					while(it.hasNext()){
						if(it.next().equals(action.getActionCard())){
							it.remove();
						}
					}
					
//					((ShanWeiPlayer)player).getNoFeeGangCards().clear();
				}
				log.info("playID  = " + playID + " 养马:" + action+" end");
			}
		};
	}
	public ContextHandler<MajongContext> yangMaAftAction() {
		return new ContextHandler<MajongContext>() {
			
			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 处理养马:" + action+" start");
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getLastPlayer();
				
				byte actionCard = gameInfo.getLastPlayCard();
//				gameInfo.setGangCount(gameInfo.getGangCount()+1);
//				player.setAddGangCount(player.getAddGangCount()+1);;
				Byte temp1=Byte.valueOf(actionCard+"");
				List<Byte> temp2=Lists.make(temp1,temp1,temp1);
				for(OpenCard openCard:player.getOpenCards()){
					if(openCard.getOpenCards().equals(temp2)){
						openCard.getOpenCards().add(temp1);
						openCard.setOpenCardsType(Constants.ACTION_ID_YANGMA);
						break;
					}
				}
//				player.getCloseCards().remove(Byte.valueOf(actionCard));//5.19
				if(gameInfo.isGang()) gameInfo.setGangOnGang(true);
				gameInfo.setGang(true);
				gameInfo.setInLoopGang(false);//5.19
				//5.19 补发加杠
				gameInfo.getPlayers().forEach(
					p->{
						if(p.isResumeInLoopGang()){
							MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
							sendAction.setUserID(player.getUserId());
							sendAction.setActionID(Constants.ACTION_ID_YANGMA);
							sendAction.setActionResult(1);
							sendAction.setActionCard(actionCard);
							sendAction.setCbCards(new byte[]{actionCard,actionCard,actionCard,actionCard});
							sendAction.setServertime(System.currentTimeMillis());
							sendMessageToPlayerOne(p, sendAction);
							p.setResumeInLoopGang(false);
						}
					}
				);
//				player.getActions().clear();
				gameInfo.getActionPlayers().add(player);
				context.setSignal(KEY_NEED_DRAW_CARD, true);
				context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());

			}
		};
	}

	public ContextHandler<MajongContext> settleAction() {
		return new ContextHandler<MajongContext>() {
			@Override
			public void call(MajongContext context) throws Exception {

				Byte gameOverType=context.getSignal(KEY_WINTYPE,null);
				checkArgument(gameOverType!=null, "gameOverType null");
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				// 算分
				gameInfo.setRound(gameInfo.getRound()+1);
//				gameInfo.setStatus(MJLogic.STATUS_GAMEOVER);
				gameInfo.setWintype(gameOverType);
				context.getLogic().settle();
				// 发送结算消息
				ShanWeiGameOverMessage overData = new ShanWeiGameOverMessage();
				overData.setPlayID(playID);
				overData.setWintype(gameOverType);
				overData.setHasHuCount(gameInfo.getHasHuCount());
				
				int winType = gameInfo.getWintype();
				
				if (winType!=WINTYPE_FLOW) {
					ShanWeiPlayer win = (ShanWeiPlayer) gameInfo.getWinners().get(0);
					
					//TODO 
					int maimaSize= 0;
					int jiangmaSize= 0;
					for (String s : gameInfo.getWanfa()) {
						if(s.startsWith(ShanWeiWanFa.WF_MATYPE_JIANGMA)){
							String substring1 = s.substring(ShanWeiWanFa.WF_MATYPE_JIANGMA.length());
							try {
								jiangmaSize=Integer.parseInt(substring1);
								log.info("-=-=-=-=-=-=-=-=----=奖马："+jiangmaSize);
								
							} catch (Exception e) {
								jiangmaSize= 0;
								log.info("=-=-=-=-=-=-=奖马为0");
							}
						}
						
					}
					for (String s : gameInfo.getWanfa()) {
						if(s.startsWith(ShanWeiWanFa.WF_MATYPE_MAIMA)){
							String substring2 = s.substring(ShanWeiWanFa.WF_MATYPE_MAIMA.length());
							try {
								maimaSize=Integer.parseInt(substring2);
								log.info("--=-=-=-=-=-=-=-=-=-=买马："+maimaSize);
							} catch (Exception e) {
								maimaSize = 0;
								log.info("-=-=-=-=-=-=买马为0");
							}
						}
					}
					
					List<BasePlayer> winnners = gameInfo.getWinners();
					List<Byte> winMaCards=new ArrayList<>();
					log.info("赢家数量："+winnners.size());
					for(int j=0;j<winnners.size();j++){
						ShanWeiPlayer winn=(ShanWeiPlayer)winnners.get(j);
						log.info(winn.getUserId()+"-马牌-"+winn.getMaCards());
						winMaCards.addAll(winn.getMaCards());
					}
					
					//翻马信息
					//1 翻马类型 2 加一个fanmainfo
					if(jiangmaSize>0){
					    overData.setFanmaTypeInfo(1);
					    List<Fanma> fms=new ArrayList<>();
					    List<Byte> maCards = ((ShanWeiGameInfo)gameInfo).getMaCards();
					    List<Byte> showjiangMaCards = win.getShowjiangMaCards();
					    for (byte c : maCards) {
							Fanma fam=new Fanma();
							fam.setFanmaInfo(c);
							fam.setIsMa(showjiangMaCards.contains(c)?1:0);//0暗 1亮
							fms.add(fam);
						}
					    overData.setFanmaInfo(fms);
					}
					if(maimaSize>0){
						ShanWeiGameInfo shanWeiGameInfo = (ShanWeiGameInfo)gameInfo;
						overData.setFanmaTypeInfo(2);
						
//						List<Fanma> fms2=new ArrayList<>();
						Map<Long, List<Fanma>> maimainfo2 = new HashMap<Long, List<Fanma>>();
						
						for (int i = 0; i < gameInfo.getPlayers().size(); i++) {
							BasePlayer player=shanWeiGameInfo.getPlayers().get(i);
							ShanWeiPlayer swp = (ShanWeiPlayer)player;
							List<Fanma> fms = new ArrayList<>();
							List<Byte> buyMaCards = swp.getBuyMaCards();
							List<Byte> showmaiMaCards = swp.getShowmaiMaCards();
							for (byte c : buyMaCards) {
								Fanma fam=new Fanma();
								fam.setFanmaInfo(c);
								fam.setIsMa(winMaCards.contains(c)?1:0);//0暗 1亮
								fms.add(fam);
							}
							maimainfo2.put(new Long(player.getUserId()), fms);
							//fms.clear();
						}
						overData.setMaimainfo2(maimainfo2);
					}
					if(maimaSize>0 && jiangmaSize>0){
						overData.setFanmaTypeInfo(4);
					}
					if(maimaSize==0 && jiangmaSize==0){
						overData.setFanmaTypeInfo(3);
					}
					
					//黄庄不再翻马，抢杠胡不再翻马，一炮多响不再翻马，多家抢杠胡不再翻马，不再算马
					if (gameInfo.getWinners().size()>1 || gameInfo.getWintype()==WINTYPE_FLOW) {
						overData.getFanmaInfo().clear();
						overData.getMaimainfo2().clear();
						overData.setFanmaTypeInfo(3);
					}
					//抢杠胡无马
					if (gameInfo.isLoopGang()&&gameInfo.getWinners().size()==1) {
						overData.getMaimainfo2().clear();
					}
					//单人抢杠胡无奖马
					if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIANGGANGH_WM) && gameInfo.getWinners().size()==1 && gameInfo.isLoopGang()) {
						overData.getFanmaInfo().clear();
					}
//					//七花16番无马 七花十番无马
//					if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA) || gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA)) {
//						overData.getFanmaInfo().clear();
//						overData.getMaimainfo2().clear();
//						overData.setFanmaTypeInfo(3);
//					}
					
					log.info("-=-=-=-==-=00赢家花牌数：" + gameInfo.getWinners().get(0).getFlowerCards().size());
					log.info("-=-=-=-==-=01赢家花牌数：" + gameInfo.getFlowerCards().size());
					
					ShanWeiPlayer swPlayer = (ShanWeiPlayer)gameInfo.getWinners().get(0);
					
					if ((gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA)||gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA))&&swPlayer.getFlowerCards().size()>=7&&swPlayer.isCanqihuahu()){
						overData.getFanmaInfo().clear();
						overData.getMaimainfo2().clear();
						overData.setFanmaTypeInfo(3);
					}
					
				}
				
				Map<Long,Test> extraData=new HashMap<>();
				for (int i = 0; i < gameInfo.getPlayers().size(); i++) {
					ShanWeiPlayer player=(ShanWeiPlayer)gameInfo.getPlayers().get(i);
//					extraData.put(player.getUserId(), Ints.checkedCast(player.getUserId()));
					extraData.put(player.getUserId(), new Test());//<=
					UUserInfo info = GameUserManager.getUserInfo(player.getUserId());
					ScoreItem2 sItem = new ScoreItem2();
 					sItem.setUserID(player.getUserId());
					sItem.setNikeName(info.getNickName());
					sItem.setFlowerCards(Lists.trans(player.getFlowerCards()));
					sItem.setCloseCards(Lists.trans(player.getCloseCards()));
					boolean isWinner=gameInfo.getWinners().contains(player);
					if(isWinner){
						if(gameOverType==WINTYPE_SELF_HU){
							sItem.setLastCard(player.getDoorCard());
							List<Byte> nCloseCards=new ArrayList<>(player.getCloseCards());
							nCloseCards.remove(Byte.valueOf(player.getDoorCard()));
							sItem.setCloseCards(Lists.trans(nCloseCards));
						}else{
							sItem.setLastCard(gameInfo.getLastPlayCard());
						}
					}
					
					/**动作牌 5.19 **/
					byte[] opc=new byte[0];
					byte[] opcac=new byte[0];
					byte[] opct=new byte[0];
					long[] opcui=new long[0];
					List<OpenCard> openCards=player.getOpenCards();
					for(OpenCard openCard:openCards){
						opc=Bytes.concat(opc, openCard.getOpenCards().get(0));
						opcac=Bytes.concat(opcac, openCard.getOpenCardsOrig());
						opct=Bytes.concat(opct, openCard.getOpenCardsType());
						opcui=Longs.concat(opcui, new long[]{openCard.getOpenCardsUserID()});
						
//						byte openCardsType = openCard.getOpenCardsType();
//						if((openCard.getOpenCardsOrig()==gameInfo.getLastPlayCard()) && gameInfo.isLoopGang()){
//							openCardsType=Consts.CARDTYPE_ADDGANG;
//							Byte temp=Byte.valueOf(gameInfo.getLastPlayCard());
//							player.getCloseCards().remove(temp);
//						}
//						opct=Bytes.concat(opct,openCardsType);
					}
					sItem.setOpenCards(opc);
					sItem.setOpenCardsActCard(opcac);
					sItem.setOpenCardsType(opct);
					sItem.setOpenCardUserId(opcui);
					
					/**统计杠花**/
					/*if(isWinner){
						int gangFlower=0;
						for(OpenCard openCard:player.getOpenCards()){
							boolean isGang=false;
							if(openCard.getOpenCardsType()==CARDTYPE_CLEARGANG){
								isGang=true;
								gangFlower++;
							}
							if(openCard.getOpenCardsType()==CARDTYPE_ADDGANG){
								isGang=true;
								gangFlower++;
							}
							if(openCard.getOpenCardsType()==CARDTYPE_ANGANG){
								isGang=true;
								gangFlower+=2;
							}
							if(isGang && openCard.getOpenCards().get(0)>=CARD_DONG){
								gangFlower++;
							}
						}
						sItem.setTotalGangGold(gangFlower);
					}*/
					
					sItem.setResult(player.getResult());
					sItem.setTotalGold(player.getScoreDiff());
					sItem.setTakenCash(player.getScore());
					
					sItem.setGang(player.getAddGangCount()+player.getAnGangCount()+player.getClearGangCount());
					
					if(gameInfo.getWinners().contains(player)){
						List<Fan> fans=player.getFans();
						String[] names=new String[fans.size()];
						int[] fan=new int[fans.size()];
						for(int ii=0;ii<fans.size();ii++){
							names[ii]=fans.get(ii).getFanName();
							if(names[ii]=="养马"){
								log.info("养马 不计分数");
								fan[ii]=0;
							}else{
								fan[ii]=fans.get(ii).getFan();
							}
						}
						sItem.setPolicyNames(names);
						sItem.setPolicyScores(fan);
					}
					
					overData.addScoreItems(sItem);
				}
//				gameInfo.setCachedGameOverMsg(overData);
//				for (int i=0;i<gameInfo.getUserCount();i++) {
//					BasePlayer player=gameInfo.getPlayers().get(i);
//					player.setScoreCount(player.getScoreCount()+player.getScoreDiff());
//					sendMessageToPlayerOne(player, overData);
//				}
				
				//8.29
				if(desk.getSetting().getCustemConf().getRoundSum() <= gameInfo.getRound()){
					overData.setIsOver(true);
				}
				
				gameInfo.setCachedGameOverMsg(overData);
				for (int i=0;i<gameInfo.getUserCount();i++) {
					BasePlayer player=gameInfo.getPlayers().get(i);
					player.setScoreCount(player.getScoreCount()+player.getScoreDiff());
					sendMessageToPlayerOne(player, overData);
				}
				
				//统计
				long[] userIds=new long[gameInfo.getUserCount()];
				long[] cashTmpDiff=new long[gameInfo.getUserCount()];
				int[] hudiff=new int[gameInfo.getUserCount()];
				for(int i=0;i<gameInfo.getPlayers().size();i++){
					BasePlayer player=gameInfo.getPlayers().get(i);
					userIds[i]=player.getUserId();
					cashTmpDiff[i]=player.getScoreDiff();
					hudiff[i]=player.getResult()==RESULT_WIN?1:0;
				}

                // 判断是否续一局
                desk.endRound(Lists.emptyList());
                // 修改标志位
                gameRun = false;

                // 单局战绩扩展字段
                Map<String, Integer> extraParam = new HashMap<>();
                // 发送房间结算event
//                desk.sendRoundPlaySettle(getPlayID(), userIds, cashTmpDiff, startTime, extraParam);//2.0.8
                sendRoundPlaySettle(getPlayID(), context, userIds, cashTmpDiff, startTime, extraParam);  //更新代码 2.6.0.4
                
                log.info("playID  = " + playID + " gameOver end");
				
				/*//统计
				long[] userIds=new long[gameInfo.getUserCount()];
				long[] cashTmpDiff=new long[gameInfo.getUserCount()];
				int[] hudiff=new int[gameInfo.getUserCount()];
				for(int i=0;i<gameInfo.getPlayers().size();i++){
					BasePlayer player=gameInfo.getPlayers().get(i);
					userIds[i]=player.getUserId();
					cashTmpDiff[i]=player.getScoreDiff();
					hudiff[i]=player.getResult()==RESULT_WIN?1:0;
				}
//				String recordName = msgRecorder().writeRecordFile();
				String recordName = NewMJMsgRecorder.writeRecordFile(getPlayID());
				desk.endRound(Lists.emptyList());
				
				// 10.23
                // 获取房间信息
                int roomId = Ints.checkedCast(desk.getSetting().getRoomId());
                PrivateRoomData privateRoomData = PrivateRoomManager.getRoom(roomId).getRoomData();
                // 累计分数
                HashMap<Long, List> playerScores = privateRoomData.getPlayerScore();
                for (int i = 0; i < gameInfo.getPlayers().size(); i++) {
                    long userId = gameInfo.getPlayers().get(i).getUserId();
                    int totalScore = (int) playerScores.get(userId).get(0);
                    playerScores.get(userId).set(0, (int) (cashTmpDiff[i] + totalScore));
                }
                // 获取俱乐部信息
                long clubId = privateRoomData.getClubId();
                int gameCard = privateRoomData.getPrivateConfig().getRoomFeeSum();
				
				//房间结算一次
				desk.sendRoundPlaySettle(userIds, cashTmpDiff,startTime, recordName);
//				desk.sendRoundPlaySettle(userIds, cashTmpDiff,startTime, recordName,true);
				//战绩
//				RoomCache roomCache=desk.getSetting().getRoomCache();
//				SPrivateroomInfo roomCache=desk.getSetting().getCustemConf();
				
				int gameId=desk.getGameId();
				
//				roomCache.getExtendColumn1();
//				roomCache.getExtendColumn2();
//				roomCache.getExtendColumn3();
				Map<String,Integer> extraParam=new HashMap<>();
				extraParam.put("a", 1000);
				extraParam.put("b", 2000);
				extraParam.put("c", 3000);
//				GameUserManager.addUserPYJRecords(roomCache.getGameId(), roomCache.getRoomId(), new Date(startTime), Lists.newArrayList(userIds), Lists.newArrayList(cashTmpDiff), recordName,extraParam);
//				GameUserManager.addUserPYJRecords(roomCache.getGameId(), ((SPrivateroomInfo)roomCache).getRoomId(), new Date(startTime), Lists.newArrayList(userIds), Lists.newArrayList(cashTmpDiff), recordName,extraParam);
				
				// 10.23
				GameUserManager.addUserPYJRecords(gameId, roomId, gameInfo.getPlayers().size(), gameCard, clubId, new Date(startTime), Lists.newArrayList(userIds), Lists.newArrayList(cashTmpDiff), recordName,extraParam);
				gameRun = false;
				log.info("playID  = " + playID + " gameOver end");*/
			
			}
		};
	}

	public ContextHandler<MajongContext> pengAction() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 碰: " + action+" start");
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				long inUserID = action.getUserID();
				int actionResult = action.getActionResult();
				byte actionCard = gameInfo.getLastPlayCard();
				BasePlayer player=gameInfo.getPlayer(inUserID);
				checkArgument(gameInfo.getActionPlayers().contains(player));
				BasePlayer lastPlayer=gameInfo.getLastPlayer();
//				boolean canChi=player.getActions().contains(ACTION_CHI);
				player.getActions().clear();
				gameInfo.getActionPlayers().remove(player);
				if (actionResult == 0) {
//					if(canChi) player.getActions().add(ACTION_CHI);
					((ShanWeiPlayer)player).getCannotPengCard().add(actionCard);
				}else{
					//碰了  查手牌  如果他有3張的情況下  那麼就是不杠而碰
					long count = player.getCloseCards().stream().filter(c->{return c==actionCard;}).count();
					if(count==3){
						((ShanWeiPlayer)player).getNoFeeGangCards().add(actionCard);
						context.setSignal((int)(Constants.ACTION_ID_YANGMA+actionCard), actionCard);
					}
					int actionID = action.getActionID();
					byte[] cbCards = new byte[] { actionCard, actionCard, actionCard };
					player.getCloseCards().remove(Byte.valueOf(actionCard));//1
					player.getCloseCards().remove(Byte.valueOf(actionCard));//2
					lastPlayer.getPlayCards().remove(lastPlayer.getPlayCards().size()-1);
					gameInfo.getDisCards().remove(gameInfo.getDisCards().size()-1);
					
					//可以杠和碰，但不杠，先碰，标记补杠后不计分
//					boolean buGangXianPeng=player.getCloseCards().contains(actionCard);
//					if(buGangXianPeng){
//						log.info(actionCard+"/先碰不杠");
//						context.setSignal((int)(Constants.ACTION_ID_YANGMA+actionCard), actionCard);
//					}
					
					
					Byte temp1=Byte.valueOf(actionCard);
					OpenCard openCard=new OpenCard(
							Lists.make(temp1,temp1,temp1), 
							gameInfo.getLastPlayCard(), 
							Byte.valueOf(actionID+""), 
							lastPlayer.getUserId());
					player.getOpenCards().add(openCard);
					
					// 碰后不能天胡
					for(BasePlayer player2 :gameInfo.getPlayers()) {
						player2.setCanTianHu(false);
					}
					
					MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
					sendAction.setUserID(inUserID);
					sendAction.setActionID(actionID);
					sendAction.setActionResult(actionResult);
					sendAction.setActionCard(actionCard);
					sendAction.setCbCards(cbCards);
					sendAction.setLastPlayUserID(lastPlayer.getUserId());
					sendAction.setServertime(System.currentTimeMillis());
					sendMessageToPlayer(Lists.emptyList(), sendAction);
				}
				log.info("playID  = " + playID + " 碰:" + action+" end");
			
			}
			
		};
	}

	private ContextHandler<MajongContext> pengAftAction() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {

				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				int actionResult = action.getActionResult();
				if(actionResult==0){
					byte lastPlayerCard=getGameInfo().getLastPlayCard();
					BasePlayer lastPlayer=getGameInfo().getLastPlayer();
					BasePlayer downPlayer=getGameInfo().getDownPlayer(lastPlayer);
					getGameInfo().getActionPlayers().addAll(checkAction(lastPlayerCard, Lists.make(downPlayer), false, false, true));
					context.setSignal(KEY_NEED_HINT_ACTION, true);
					context.trigger(NO);
				}else{
					ShanWeiGameInfo shanWeiGameInfo=(ShanWeiGameInfo)getGameInfo();
					shanWeiGameInfo.setCanHuDiHu(false);//有碰杠，牌局不能在胡地胡
					BasePlayer player=getGameInfo().getPlayer(action.getUserID());
					getGameInfo().getActionPlayers().add(player);
					context.setSignal(KEY_NEED_DRAW_CARD, false);
					context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().checkSelfHu(false)
							.checkAddGang(false).checkAnGang(false).checkTing(true).build());// 碰完可以检测是否听牌，更新胡牌提示
//					context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().CheckSelfHu(false)
//							.CheckAddGang(false).CheckAnGang(false).CheckTing(true).build());// 碰完可以检测是否听牌，更新胡牌提示
					context.trigger(YES);
				}
			}
		};
	}
	
	/**
	 * 抢杠问询
	 * @return
	 */
	public ContextHandler<MajongContext> loopGangAsk() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {
				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 抢杠问询:" + action);
				int actionResult = action.getActionResult();
				long inUserID = action.getUserID();
				int actionID = action.getActionID();
				byte[] cbCards = action.getCbCards();
				byte actionCard=action.getActionCard();
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getPlayer(inUserID);
				List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
//				if(actionResult==1){
////					ShanWeiPlayer tmp=(ShanWeiPlayer) player;
////					tmp.setBeiqianggang(true);
////					getGameInfo().setLastPlayer(player);
//					player.getOpenCards().get(0).setOpenCardsType(Consts.CARDTYPE_ADDGANG);
//				}
				if((actionID==ACTION_ADDGANG || actionID==Constants.ACTION_ID_YANGMA) && actionResult==0){
//					player.getActions().clear();
					context.setSignal(KEY_NEED_DRAW_CARD, false);
//					context.setSignal(KEY_NEED_HINT_ACTION, false);
					context.trigger(NO);
					return;
				}
				
				boolean executeJiaGang=context.getSignal(KEY_EXECUTE_JIAGANG,false);
				if(executeJiaGang){
					context.trigger(EXECUTE_JIAGANG);
					return;
				}
//				boolean executeYangMa=context.getSignal(KEY_EXECUTE_YANGMA,false);
//				if(executeYangMa){
//					context.trigger(getEvent(Constants.EXECUTE_YANGMA));
//					return;
//				}
				
				boolean firstJiaGangAsk=context.getSignal(KEY_FIRST_JIAGANG_ASK,false);
				if(firstJiaGangAsk){
					context.setSignal(KEY_FIRST_JIAGANG_ASK, false);
					MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
					sendAction.setUserID(inUserID);
					sendAction.setActionID(actionID);
					sendAction.setActionResult(actionResult);
					sendAction.setActionCard(actionCard);
					sendAction.setCbCards(cbCards);
					sendAction.setServertime(System.currentTimeMillis());
					sendMessageToPlayer(Lists.emptyList(), sendAction);
					
					player.getActions().clear();
					actionPlayers.remove(player);
					gameInfo.setLastPlayCard(actionCard);
					gameInfo.setLastPlayer(player);
					
//					List<BasePlayer> temp=new ArrayList<>(gameInfo.getPlayers());
					List<BasePlayer> temp=Lists.circleList(gameInfo.getPlayers(), player);
					temp.remove(player);
					 
					actionPlayers.addAll(checkAction(actionCard, temp, true, false, false));
					
					if(actionPlayers.isEmpty()){
						context.trigger(EXECUTE_JIAGANG);
						return;
					}
				}
				
				boolean needHintHu=context.getSignal(KEY_NEED_HINT_ACTION,false);
				if(firstJiaGangAsk || needHintHu){
					for(BasePlayer p:actionPlayers){
						MMajongPressCardMsg pressCard = new MMajongPressCardMsg();
						pressCard.setPlayID(playID);
						pressCard.setServertime(System.currentTimeMillis());
						if (p.getActions().size()>0) {
//							pressCard.setActions(Lists.trans(p.getActions())); // 设置用户特殊操作参数
//							pressCard.setNextPlayer(p.getUserId()); // 设置用户特殊操作参数
//							log.debug("playID=" + playID + ",hint action: " + pressCard);
//							sendMessageToPlayerOne(p, pressCard);
	                        /**edit 抢杠胡修改Start*/
                            if (p.getActions().contains(Byte.valueOf(Consts.ACTION_HU))) {
                                p.getActions().remove(Byte.valueOf(Consts.ACTION_HU));// 胡 标记改为抢杠胡标记
                                p.getActions().add(Byte.valueOf(Consts.ACTION_LOOPGANG));//抢杠胡 9
                            }
                            /**edit 抢杠胡修改End*/
                            pressCard.setActions(Lists.trans(p.getActions())); // 设置用户特殊操作参数
//                            pressCard.setNextPlayer((int) p.getUserId()); // 设置用户特殊操作参数
                            pressCard.setNextPlayer(p.getUserId()); // 设置用户特殊操作参数//2.0.8
                            log.debug("playID=" + playID + ",hint action: " + pressCard);
                            sendMessageToPlayerOne(p, pressCard);
						}
					}
				}
			}
		};
	}
	
	public List<Byte> mergeTingCards(List<TingPattern> tingPatterns,Byte card){
		Set<Byte> ths = new HashSet<Byte>();
		for(TingPattern tingPattern:tingPatterns){
			if(tingPattern.getPlayCard()==card){
				ths.addAll(tingPattern.getTingCards());
			}
		}
		return new ArrayList<Byte>(ths);
	}

	public ContextHandler<MajongContext> preCard() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {
				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				ShanWeiGameInfo gameInfo=(ShanWeiGameInfo)context.getGameInfo();
				List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
				checkArgument(actionPlayers.size()==1, "actionPlayers: "+actionPlayers);
				ShanWeiPlayer actionPlayer=(ShanWeiPlayer)actionPlayers.remove(0);
				checkArgument(actionPlayer.getUserId()==action.getUserID(), "actionPlayers: "+actionPlayers);
				
				log.info("playID  = " + playID + " 出牌,action = " + action);
				byte playCard = action.getActionCard();
				actionPlayer.getCloseCards().remove(Byte.valueOf(playCard));
				actionPlayer.getActions().clear();
				actionPlayer.getCannotHuCard().clear();
				actionPlayer.setCanHu(true);
				actionPlayer.getPlayCards().add(playCard);
				
				gameInfo.getDisCards().add(playCard);
				gameInfo.setLastPlayCard(playCard);
				gameInfo.setLastPlayer(actionPlayer);
				
				if (!actionPlayer.equals(gameInfo.getBanker())&&actionPlayer.isCandihu()) {//闲出牌，则设置不能地胡
					gameInfo.setCanHuDianPaoDiHu(false);//牌局不能再是点炮地胡
					actionPlayer.setCandihu(false);
				}
				
				actionPlayer.setCanTianHu(false);
				actionPlayer.setCanTianTing(false);
				actionPlayer.getCannotPengCard().clear();
				
//				for(TingInfo tingInfo:actionPlayer.getTingInfos()){
//				if(tingInfo.getPlayForTingCard()==playCard){
//					actionPlayer.setHuCards(tingInfo.getTingCards());
//					break;
//				  }
//			   }
//				for(TingPattern tingPattern:actionPlayer.getTingPatterns()){
//					if(tingPattern.getPlayCard()==playCard){
//						actionPlayer.setHuCards(new ArrayList<>(tingPattern.getTingCards()));
//						break;
//					}
//				}
				
				//听牌状态，打牌需要更新胡牌提示
				/*if (!actionPlayer.getTingInfos().isEmpty()) {
					List<Byte> playCard4Ting= new ArrayList<>();
					List<List<Byte>> huCardsList= new ArrayList<>();
					actionPlayer.getTingInfos().stream().forEach((tempInfo)->{
						playCard4Ting.add(tempInfo.getPlayForTingCard());
						huCardsList.add(tempInfo.getTingCards());
					});
					int indexHucard= playCard4Ting.indexOf(playCard);
					if (indexHucard!= -1) {
						if (huCardsList.get(indexHucard).contains(Consts.CARD_NONE)) {
							huCardsList.set(indexHucard, Consts.ALL_CARDS);
						}
						actionPlayer.setHuCards(huCardsList.get(indexHucard));
					}else {
						actionPlayer.getTingInfos().clear();
						actionPlayer.getHuCards().clear();
					}
				}else {
					actionPlayer.getHuCards().clear();
				}*/
				
				actionPlayer.setHuCards(mergeTingCards(actionPlayer.getTingPatterns(),playCard));
				MMajongPressCardMsg pressCard = new MMajongPressCardMsg();
				pressCard.setPlayID(playID);
				pressCard.setPlayedby(action.getUserID());
				pressCard.setPlayCard(playCard);
				pressCard.setRemainCount(getLogic().getRemainCount());
				pressCard.setClienttime(action.getClienttime());
				pressCard.setServertime(System.currentTimeMillis());
				
				//加入胡牌提示
				
				sendMessageToPlayer(Lists.emptyList(), pressCard);
				log.info("playID  = " + playID + " onPlayCard,action = " + action+ " end");
				
				List<BasePlayer> temp=Lists.circleList(gameInfo.getPlayers(), actionPlayer);
				temp.remove(actionPlayer);
				//不需要过圈胡
//				for (BasePlayer bp:temp) {
//					bp.setCanHu(true);
//					bp.getCannotHuCard().clear();
//				}
				//是否 点炮胡、吃 根据配置
//				boolean checkHuFlag=false;
//				boolean checkChiFlag=false;
//				if(gameInfo.getWanfa().contains(ShanWeiLogic.WF_KE_DIAOPAO)) checkHuFlag=true;
//				if(gameInfo.getWanfa().contains(HongZhongLogic.WF_KE_CHI)) checkChiFlag=true;
				actionPlayers.addAll(checkAction(playCard, temp, true, true, true));
				if(gameInfo.isGang()){//杠开杠炮维护
					if(actionPlayers.isEmpty() || !actionPlayers.get(0).getActions().contains(ACTION_HU)){
						gameInfo.setGang(false); //杠上后，没有胡，重新设置变量，取消掉已杠
						gameInfo.setGangOnGang(false); //杠了之后又杠上了，摸牌后没胡，结束掉杠上杠
					}
				}
				context.setSignal(KEY_NEED_HINT_ACTION, true);
			}
		};
	}

	public ContextHandler<MajongContext> init() {
		return new ContextHandler<MajongContext>() {
			@Override
			public void call(MajongContext context) throws Exception {
				/**---init context---**/
				log.info("playID = " + playID + " init context");
				ShanWeiGameInfo lastGameInfo=(ShanWeiGameInfo) context.getLastGameInfo();
				ShanWeiGameInfo newGameInfo=new ShanWeiGameInfo();   //<=
				
//				HuStrategy[] huStrategys= new HuStrategy[]{HuHelper.HU_SHISANYAO,HuHelper.HU_NORMAL_WITH_LAIZI_SPECIAL_01, HuHelper.HU_NORMAL_WITH_LAIZI_SPECIAL_02,HuHelper.HU_NORMAL_WITH_LAIZI_SPECIAL_03};
//				newGameInfo.setHuStrategys(huStrategys);//必须设置胡牌策略
				
				boolean isFirst=lastGameInfo==null;
				context.setLastGameInfo(lastGameInfo);
				context.getSignals().clear();
				context.setGameInfo(newGameInfo);
				ShanWeiLogic logic=new ShanWeiLogic();   //<=
				context.setLogic(logic);
				logic.setGameInfo(newGameInfo);
				
				/**---init gameinfo**/
				log.info("playID = " + playID + " init gameinfo");
				//初始化局数
				if(isFirst){
					newGameInfo.setTotalRound(desk.getSetting().getTotalRound());
					newGameInfo.setRound(0);
				}else{
//					newGameInfo.setCountZhuang(lastGameInfo.getCountZhuang());
					newGameInfo.setTotalRound(lastGameInfo.getTotalRound());
					newGameInfo.setRound(lastGameInfo.getRound());
				}
				//初始化 player
				List<Long> playerIds=desk.getPlayers();
				Builder<BasePlayer> builder=ImmutableList.builder();
				for(Long id:playerIds){
					ShanWeiPlayer player=new ShanWeiPlayer();   //<=
					player.setTianHu(false);//可以天胡
					player.setCandihu(true);//可以地胡
//					player.setCanTianHu(true);
					player.setCanTianTing(false);
					player.setUserId(id);
					builder.add(player);
					if(isFirst){
						//初始分
						int score = desk.getSetting().getCustemConf().getInitScore();
						player.setScore(score);
					}else{
						BasePlayer oplayer=Lists.find(lastGameInfo.getPlayers(),p->{return p.getUserId()==id;});
						player.setScore(oplayer.getScore());
						Reflections.fieldValueCopy(oplayer, player, (f)->{return f.getAnnotation(Copyable.class)!=null;});
					}
				}
				List<BasePlayer> players=builder.build();
				newGameInfo.setPlayers(players);
				
				// 获取玩法
				List<String> wanfa = newGameInfo.getWanfa();
				String[] tmp = desk.getSetting().getCustemConf().getWanfa().split("\\|");
				for (int i = 0; i < tmp.length; i++) {
					wanfa.add(tmp[i]);
				}
				
				
				int maimaSize= 0;
				int jiangmaSize= 0;
				for (String s :wanfa) {
					if(s.startsWith(ShanWeiWanFa.WF_MATYPE_JIANGMA)){
						String substring1 = s.substring(ShanWeiWanFa.WF_MATYPE_JIANGMA.length());
						try {
							jiangmaSize=Integer.parseInt(substring1);
							log.info("-=-=-=-=-=-=-=-=----=奖马："+jiangmaSize);
							
						} catch (Exception e) {
							jiangmaSize= 0;
							log.info("=-=-=-=-=-=-=奖马为0");
						}
					}
					
				}
				for (String s : wanfa) {
					if(s.startsWith(ShanWeiWanFa.WF_MATYPE_MAIMA)){
						String substring2 = s.substring(ShanWeiWanFa.WF_MATYPE_MAIMA.length());
						try {
							maimaSize=Integer.parseInt(substring2);
							log.info("--=-=-=-=-=-=-=-=-=-=买马："+maimaSize);
							
						} catch (Exception e) {
							maimaSize = 0;
							log.info("-=-=-=-=-=-=买马为0");
						}
					}
					
				}
				newGameInfo.setMjTest(isMjTest());
				//初始化庄家
				BasePlayer banker;
				if(isFirst){
					//第一局东风庄
					banker=newGameInfo.getPlayers().get(0);
					newGameInfo.setBanker(banker);
					newGameInfo.setFirstBanker(banker);
//newGameInfo.setCountZhuang(1);
				}else{
					long bankerId=lastGameInfo.getBanker().getUserId();
					long firstBankerId=lastGameInfo.getFirstBanker().getUserId();
					banker=Lists.find(newGameInfo.getPlayers(), p->{return p.getUserId()==bankerId;});
					boolean isZhuangWin=lastGameInfo.getWinners().contains(banker);
					boolean isFlow=lastGameInfo.getWinners().isEmpty();
					if (lastGameInfo.isLoopGang() || lastGameInfo.getWinners().size()>1) {
						//或者一炮多响 抢杠胡 被抢的人上庄
						long id = lastGameInfo.getLastPlayer().getUserId();
						banker=Lists.find(newGameInfo.getPlayers(), p->{return p.getUserId()==id;});
					}else if (isZhuangWin || isFlow/* && !wanfa.contains(ShanWeiWanFa.WF_JIANGMA_10)*/) {
						// 赢家赢 或 流局， 连庄
					} else if(!isZhuangWin && !isFlow) {
						//否则 霸王庄 赢家连庄
						banker=newGameInfo.getPlayer(lastGameInfo.getWinners().get(0).getUserId());
					}
					
					log.info("-》》》》》》》》》》》》》》》上一局的庄家是："+lastGameInfo.getBanker().getUserId());
					log.info("-》》》》》》》》》》》》》》》新一局的庄家是："+banker.getUserId());
					
					
					BasePlayer firstBanker=Lists.find(newGameInfo.getPlayers(), p->{return p.getUserId()==firstBankerId;});
					newGameInfo.setBanker(banker);
					newGameInfo.setFirstBanker(firstBanker);
					newGameInfo.setHasChangeBanker(!banker.equals(lastGameInfo.getBanker()));
				}
				((ShanWeiPlayer)banker).setCandihu(false); //庄不能地胡
//				//初始化圈风门风
				if(newGameInfo.isHasChangeBanker() && newGameInfo.getFirstBanker().equals(banker)){
					int wind=lastGameInfo.getCircleWind()+1;
					if(wind>CIRCLEWIND_BEI) wind=CIRCLEWIND_DONG;
					newGameInfo.setCircleWind(wind);
				}else{
					if(!isFirst)
						newGameInfo.setCircleWind(lastGameInfo.getCircleWind());
				}
				if(isFirst){
					int index=players.indexOf(banker);
					for(int i=0;i<players.size();i++){
						int temp=i-index;
						if(temp<0) temp=4+temp;
						players.get(i).setDoorWind(Byte.valueOf(DOORWIND_DONG+temp+""));
					}
				}
				
				/*
				 * 门风，3人麻将只有东，南，西；2人麻将只有东和西
				 */
				int index = players.indexOf(newGameInfo.getBanker());
				if (players.size()== 4) {
					for (int i = 0; i < players.size(); i++) {
						int temp = i - index;
						if (temp < 0)
							temp = 4 + temp;
						players.get(i).setDoorWind(Byte.valueOf(DOORWIND_DONG + temp + ""));
					}
				}else if (players.size()== 3) {
					for (int i = 0; i < players.size(); i++) {
						int temp = i - index;
						if (temp < 0){
							temp = 3 + temp;
						}
						if(Byte.valueOf(Consts.DOORWIND_DONG+ temp+ "")== Consts.DOORWIND_DONG){
							players.get(i).setDoorWind(Consts.DOORWIND_DONG);
						}else if (Byte.valueOf(Consts.DOORWIND_DONG+ temp+ "")== Consts.DOORWIND_NAN) {
							players.get(i).setDoorWind(Byte.valueOf(DOORWIND_DONG + temp + ""));
						}else {
							players.get(i).setDoorWind(Consts.DOORWIND_XI);
						}
					}
				}else if (players.size()== 2) {
					for (int i = 0; i < players.size(); i++) {
						if (i== index) {
							players.get(i).setDoorWind(Byte.valueOf(DOORWIND_DONG+""));
						}else {
							players.get(i).setDoorWind(Byte.valueOf(Consts.DOORWIND_NAN+""));
						}
					}
				}
				
				
				//初始化花
				newGameInfo.getFlowerCards().addAll(Consts.FLOWER_CARDS);
				
// 流局张数确定 ？？？
				log.info("=================翻马数量： "+desk.getSetting().getCustemConf().getFanma());
				/*if (desk.getSetting().getRoomCache().getFanma() == 6) {
					logic.setMinRemainCount(6);
				} else {
					logic.setMinRemainCount(4);
				}*/
				// 生成牌墙
				logic.initWall();
				
				// 生成配牌
				logic.makeCard(SHANWEI);
				
				newGameInfo.setPlayType(desk.getSetting().getSubType());
//				gameInfo.setRobotLevel(1);
//				List<String> wanfa = newGameInfo.getWanfa();
//				String[] tmp = desk.getSetting().getRoomCache().getWanfa().split("\\|");
//				for (int i = 0; i < tmp.length; i++) {
//					wanfa.add(tmp[i]);
//				}
//				
				
				//根据传过来的玩法 确定马  /不管是奖马还是买马  玩家马牌不变
				//确定玩家的正字,正花牌
				
				//庄家的马牌,正字牌，正花牌
			    ((ShanWeiPlayer)banker).setMaCards(Lists.make(CARD_1TIAO,CARD_1TONG,CARD_1WAN,CARD_5TIAO,CARD_5TONG,CARD_5WAN,CARD_9TIAO,CARD_9TONG,CARD_9WAN,CARD_DONG,FLOWER_CHUN,FLOWER_MEI));
//			    ((ShanWeiPlayer)banker).setZiCards(Lists.make(CARD_DONG));
			    ((ShanWeiPlayer)banker).setZiCards(Lists.make(CARD_DONG,CARD_ZHONG,CARD_FA,CARD_BAI));
			    ((ShanWeiPlayer)banker).setHuaCards(Lists.make(FLOWER_CHUN,FLOWER_MEI));
			    //庄家下家
			    BasePlayer bankerDownPlayer = newGameInfo.getDownPlayer(banker);
			    ((ShanWeiPlayer)bankerDownPlayer).setMaCards(Lists.make(CARD_2TIAO,CARD_2TONG,CARD_2WAN,CARD_6TIAO,CARD_6TONG,CARD_6WAN,CARD_NAN,CARD_ZHONG,FLOWER_XIA,FLOWER_LAN));
//			    ((ShanWeiPlayer)bankerDownPlayer).setZiCards(Lists.make(CARD_NAN));
			    ((ShanWeiPlayer)bankerDownPlayer).setZiCards(Lists.make(CARD_NAN,CARD_ZHONG,CARD_FA,CARD_BAI));
			    ((ShanWeiPlayer)bankerDownPlayer).setHuaCards(Lists.make(FLOWER_XIA,FLOWER_LAN));
			    
			    //庄家对家
			    BasePlayer bankerDownDownPlayer = newGameInfo.getDownPlayer(bankerDownPlayer);
			    if (newGameInfo.getPlayers().size()>=3) {
			    	((ShanWeiPlayer)bankerDownDownPlayer).setMaCards(Lists.make(CARD_3TIAO,CARD_3TONG,CARD_3WAN,CARD_7TIAO,CARD_7TONG,CARD_7WAN,CARD_XI,CARD_FA,FLOWER_QIU,FLOWER_ZHU));
//			    	((ShanWeiPlayer)bankerDownDownPlayer).setZiCards(Lists.make(CARD_XI));
			    	((ShanWeiPlayer)bankerDownDownPlayer).setZiCards(Lists.make(CARD_XI,CARD_ZHONG,CARD_FA,CARD_BAI));
			    	((ShanWeiPlayer)bankerDownDownPlayer).setHuaCards(Lists.make(FLOWER_QIU,FLOWER_ZHU));
				}
			    //庄家的上家
			    if (newGameInfo.getPlayers().size()>=4) {
			    	BasePlayer bankerPrevPlayer = newGameInfo.getDownPlayer(bankerDownDownPlayer);
			    	((ShanWeiPlayer)bankerPrevPlayer).setMaCards(Lists.make(CARD_4TIAO,CARD_4TONG,CARD_4WAN,CARD_8TIAO,CARD_8TONG,CARD_8WAN,CARD_BEI,CARD_BAI,FLOWER_DONG,FLOWER_JU));
//			    	((ShanWeiPlayer)bankerPrevPlayer).setZiCards(Lists.make(CARD_BEI));
			    	((ShanWeiPlayer)bankerPrevPlayer).setZiCards(Lists.make(CARD_BEI,CARD_ZHONG,CARD_FA,CARD_BAI));
			    	((ShanWeiPlayer)bankerPrevPlayer).setHuaCards(Lists.make(FLOWER_DONG,FLOWER_JU));
				}
			    
//			    if (wanfa.contains(ShanWeiWanFa.WF_ZHENGFHUA)) {
//			    	List<Byte> huaCards = newGameInfo.getFlowerCards();
//				}
			    
//				if(wanfa.contains(ShanWeiWanFa.WF_MATYPE_JIANGMA)){
			    if (jiangmaSize>=0) {
					//奖马玩法
					List<Byte> cards = newGameInfo.getCards();
					int masize=0;
					if(wanfa.contains(ShanWeiWanFa.WF_JIANGMA_2)){
						masize=2;
					}
					if(wanfa.contains(ShanWeiWanFa.WF_JIANGMA_4)){
						masize=4;
					}
					if(wanfa.contains(ShanWeiWanFa.WF_JIANGMA_6)){
						masize=6;
					}
					if(wanfa.contains(ShanWeiWanFa.WF_JIANGMA_8)){
						masize=8;
					}
					if(wanfa.contains(ShanWeiWanFa.WF_JIANGMA_10)){
						masize=10;
					}
					List<Byte> macards=cards.subList(cards.size()-masize, cards.size());
//					List<Byte> macards= Lists.newArrayList(Consts.CARD_3TIAO,Consts.CARD_4TIAO);
					
					newGameInfo.setMaCards(new ArrayList<>(macards));
				}
//				if(wanfa.contains(ShanWeiWanFa.WF_MATYPE_MAIMA)){
			    if (maimaSize>=0) {
					//买马玩法
//					MMajongGameActionMsg action=context.getAction();
//					long userId=action.getUserID();
//					ShanWeiPlayer player=(ShanWeiPlayer) newGameInfo.getPlayer(userId);
					
					for(Long id:playerIds) {
						ShanWeiPlayer player=(ShanWeiPlayer) newGameInfo.getPlayer(id);
						List<Byte> maCards = newGameInfo.getMaCards();
						if(newGameInfo.getWanfa().contains(ShanWeiWanFa.WF_MAIMA_1)){
							player.getBuyMaCards().add(newGameInfo.getCards().remove(newGameInfo.getCards().size()-1-maCards.size()));
//							player.getBuyMaCards().add(Consts.CARD_3WAN);
							
						}
						if(newGameInfo.getWanfa().contains(ShanWeiWanFa.WF_MAIMA_2)){
							player.getBuyMaCards().add(newGameInfo.getCards().remove(newGameInfo.getCards().size()-1-maCards.size()));
							player.getBuyMaCards().add(newGameInfo.getCards().remove(newGameInfo.getCards().size()-1-maCards.size()));
						
//							player.getBuyMaCards().add(Consts.CARD_3WAN);
//							player.getBuyMaCards().add(Consts.CARD_4WAN);
						}
						
					}
				}
				
				//TODO  base的值记得初始化
				int base=1;
//				base = (int) desk.getSetting().getRoomCache().getDifen();
				for (String s : wanfa) {
					if(s.startsWith(ShanWeiWanFa.WF_DIJIN)){
						String substring = s.substring(ShanWeiWanFa.WF_DIJIN.length());
						try {
							base=Integer.parseInt(substring);
						} catch (Exception e) {
							base = 1;
							log.info("底数错误，调整为默认1底");
						}
					}
					
				}
				
				log.info("-=-=-=-=-=-=玩法规则有："+wanfa);
				
				
				//默认封顶
				boolean isfengding = true;
				if(wanfa.contains(ShanWeiWanFa.WF_NOFENGDIN)) {
					isfengding = false;
				}
				
				newGameInfo.setBase(base);
				newGameInfo.setWanfa(wanfa);
				newGameInfo.setIsfengding(isfengding);
				newGameInfo.setUserCount(playerIds.size());
				newGameInfo.setFanzi(newGameInfo.getFanzi());
//newGameInfo.setLaizi(newGameInfo.getLaizi());
//newGameInfo.setFanmaSum(desk.getSetting().getRoomCache().getFanmaSum();
				newGameInfo.setPlayId(playID);
				newGameInfo.setNeedOpenAnGang(true);//暗杠需要亮牌
				newGameInfo.setDingque(false);//定缺
				// 发牌过程,初始化玩家个人信息,从庄家开始
//				int cardsCount=logic.getRemainCount();
//				newGameInfo.setCardsCount(cardsCount);
				int countUser=players.size();
				boolean temp=true;
				for (int i=players.indexOf(banker);i<countUser;i=(i+1)%countUser) {
					BasePlayer p=players.get(i);
					if(!temp && p.equals(banker)) break;
					temp=false;
					GameUser user = GameUserManager.getUser(p.getUserId());
					p.setRouter(user.getRouterServerId());
					logic.distributeCard(p);//发牌
				}
				//发送开局消息
				MMajongGameStartMsg gStart = new MMajongGameStartMsg();
				MMajongGameStartMsg.GameUserInfo[] uInfos = new MMajongGameStartMsg.GameUserInfo[countUser];
				gStart.setDeskType(desk.getDeskType());
				gStart.setCircleWind(newGameInfo.getCircleWind());
				gStart.setGameID(desk.getGameId());
				gStart.setPlayID(playID);
				gStart.setNextUserID(banker.getUserId());
				gStart.setBankUserID(banker.getUserId());
//gStart.setCountHuang(newGameInfo.getCountZhuang());
//				gStart.setCardsSum(cardsCount);
//				gStart.setPlayTimeOut(getActTimeOut(MJLogic.ACTION_OUTCARD));
//				gStart.setActionTimeOut(getActTimeOut(MJLogic.ACTION_HU));
//				gStart.setLaizi(newGameInfo.getLaizi());
				gStart.setFanzi(newGameInfo.getFanzi());
				gStart.setPlayType(newGameInfo.getPlayType()); // 玩法类型
				gStart.setRemainCount(logic.getRemainCount());
				gStart.setXiapaolist(logic.getXiaPaoList());
				gStart.setLaZhuanglist(logic.getLaZhuangList());
				gStart.setZuoList(logic.getZuoList());
				gStart.setPlayNum(desk.getSetting().getPlayerSum());
				gStart.setDice(logic.getDice());
				gStart.setNeedOpenAnGang(newGameInfo.isNeedOpenAnGang());
				
//				byte[] wnp=new byte[]{newGameInfo.getLaizi()};
//				gStart.setWanNengPai(wnp);
				
				gStart.setFlowers(Bytes.trans(newGameInfo.getFlowerCards()));
				gStart.setWanfa(desk.getSetting().getCustemConf().getWanfa());
				gStart.setIsTing(false);//没有喊听
				if(logic.canHu(banker,CARD_NONE) || logic.canAddGang(banker) || logic.canAnGang(banker) || logic.canTing(banker)){
					gStart.setHasAction(true);
				}
//				gStart.setDingQue(newGameInfo.isDingque());//定缺
				for (int i = 0; i < countUser; i++) {
					BasePlayer p=players.get(i);
					UUserInfo userInfo = GameUserManager.getUserInfo(p.getUserId());
					uInfos[i] = new MMajongGameStartMsg.GameUserInfo();
					uInfos[i].setUserID(p.getUserId());
					uInfos[i].setNickName(userInfo.getNickName());
					uInfos[i].setIconID(userInfo.getImgId());
					uInfos[i].setSex(userInfo.getSex());
//					uInfos[i].setSetLaZhuang(logic.needLaZhuang());
//					uInfos[i].setSetXiaoPao(logic.needXiaPao());
//					uInfos[i].setSetZuo(logic.needZuo());
					uInfos[i].setXiapaoNum(p.getPao());
					GameUser user = GameUserManager.getUser(p.getUserId());
					// 写入经纬度
					uInfos[i].setJingDu(user.getLongitude());
					uInfos[i].setWeiDu(user.getLatitude());
					uInfos[i].setIpAddress(user.getIP());
					uInfos[i].setMoney(p.getScore());
					uInfos[i].setDoorWinds(p.getDoorWind());
					gStart.addUserInfoItems(uInfos[i]);
				}
				
				for (int i = 0; i < countUser; i++) {
					BasePlayer p=players.get(i);
					gStart.setCloseCards(Lists.trans(p.getCloseCards()));
					gStart.setActions(Lists.trans(p.getActions()));
					log.info("playID = " + playID + " 发送开局消息给:" + p.getUserId() + gStart);
					// 发送开局消息
					sendMessageToPlayerOne(p, gStart);
				}
				
				//庄家开局
				newGameInfo.setCurrentPlayer(banker);
				newGameInfo.getActionPlayers().add(banker);
				context.setSignal(KEY_NEED_DRAW_CARD, false);
				context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());
				context.trigger(START);
			}
		};
	}

	public ContextHandler<MajongContext> moCark() {
		return new ContextHandler<MajongContext>() {

			@Override
			public void call(MajongContext context) throws Exception {
				ShanWeiGameInfo gameInfo=(ShanWeiGameInfo)context.getGameInfo();
				List<BasePlayer> actionPlayers=gameInfo.getActionPlayers();
				checkArgument(actionPlayers.size()==1, "actionPlayers: "+actionPlayers);
				ShanWeiLogic logic=(ShanWeiLogic)context.getLogic();
				ShanWeiPlayer actionPlayer=(ShanWeiPlayer)actionPlayers.remove(0);
				gameInfo.setCurrentPlayer(actionPlayer);
				actionPlayer.getActions().add(ACTION_OUTCARD);
				//庄家第一次出牌
				boolean isBankerFirst=context.getSignal(KEY_IS_BANKER_FIRST,false);
				if(isBankerFirst){
//					int indexDoor = actionPlayer.getCloseCards().size()-1;
//					actionPlayer.setDoorCard(actionPlayer.getCloseCards().get(indexDoor));
//					Collections.sort(actionPlayer.getCloseCards());
				}
				byte ting=context.getSignal(KEY_TING, CARD_NONE);
				if(ting!=0){
					//打牌进入听状态
					MMajongGameActionMsg outCard=new MMajongGameActionMsg();
					outCard.setUserID(actionPlayer.getUserId());
					outCard.setActionID(ACTION_OUTCARD);
					outCard.setActionCard(ting);
					context.setAction(outCard);
					actionPlayers.add(actionPlayer);
					context.trigger(PLAYCARD);
					return;
				}
				
				actionPlayer.getHuCards().clear();//5.9
				
				//是否需要摸牌
				boolean needDrawCard=context.getSignal(KEY_NEED_DRAW_CARD,false);
				if(needDrawCard){
					byte card=logic.drawCard();
					if(card==CARD_NONE){
						context.setSignal(KEY_WINTYPE, WINTYPE_FLOW);
						context.trigger(GAMEFLOW);
						return;
					}else{
//						drawCard(actionPlayer, card);
						actionPlayer.setDoorCard(card);
						actionPlayer.getCloseCards().add(card);
						Collections.sort(actionPlayer.getCloseCards());
						MMajongDispenseCardMsg dmsg = new MMajongDispenseCardMsg();
						dmsg.setPlayID(playID);  
						dmsg.setUserID(actionPlayer.getUserId());
						dmsg.setCard(card);
						//听牌状态
						{//7.4
							log.info("-=-=-=-=-=-canhu"+logic.canHu(actionPlayer, CARD_NONE));
							log.info("-=-=-=-=-=-canAddGang"+logic.canAddGang(actionPlayer));
							log.info("-=-=-=-=-=-canAnGang"+logic.canAnGang(actionPlayer));
							log.info("-=-=-=-=-=-canTing"+(!actionPlayer.isTing() && logic.canTing(actionPlayer)));
							if(logic.getMinRemainCount() >= logic.getRemainCount()){
								dmsg.setHasAction(true);
							}else{
								if(logic.canHu(actionPlayer,CARD_NONE) || logic.canAddGang(actionPlayer) || logic.canAnGang(actionPlayer) || (!actionPlayer.isTing() && logic.canTing(actionPlayer))){
									dmsg.setHasAction(true);
								}
							}
						}
						sendMessageToPlayer(Lists.emptyList(), dmsg);
					}
				}else {
					if(actionPlayer.isCanTianHu()&&logic.canHu(actionPlayer,CARD_NONE)/*&&actionPlayer==gameInfo.getBanker()*/){
						actionPlayer.setTianHu(true);
					}
					//地胡待测试
//					if(actionPlayer.isCanTianHu()&&logic.canHu(actionPlayer,CARD_NONE)&&actionPlayer!=gameInfo.getBanker()){
//						actionPlayer.setTianHu(true);
//					}
				}
				
				boolean needClearDoorCard=context.getSignal(KEY_NEED_CLEAR_DOORCARD,false);
				if(needClearDoorCard){
					actionPlayer.setDoorCard(CARD_NONE);
				}
				
				boolean afterAddFlower=context.getSignal(KEY_AFTER_ADDFLOWER,false);
				if(!afterAddFlower && !needDrawCard){
					actionPlayer.setDoorCard(CARD_NONE);
				}
				
				int flowercount= actionPlayer.getFlowerCards().size();
				for(byte card:actionPlayer.getCloseCards()){
					if(logic.isFlower(actionPlayer, card)&& flowercount>= 6) {
						((ShanWeiPlayer)actionPlayer).setCanqihuahu(true);
					}
				}
				
				//是否需要补花
				for(byte card:actionPlayer.getCloseCards()){
					
					if(logic.isFlower(actionPlayer, card)){
						actionPlayers.add(actionPlayer);
						context.trigger(ADDFLOWER);
						return;
					}
				}
				
				/*
				 * 最后一张牌不能点炮,直接流局
				 */
				boolean isOver = gameInfo.getCards().size() <= logic.getMinRemainCount();
				boolean dropZiMo=context.getSignal(KEY_DROP_SELFHU,false);
				if(isOver && dropZiMo){
					context.setSignal(KEY_WINTYPE, WINTYPE_FLOW);
					context.trigger(GAMEFLOW); 	
					return;
				}
				
//				boolean needHintAction=context.getSignal(KEY_NEED_HINT_ACTION,false);
				CheckActionInfo checkActionInfo=context.getSignal(KEY_NEED_HINT_ACTION,null);
				if(checkActionInfo!=null){			
					/*
					 * 能自摸
					 */
					if (checkActionInfo.checkSelfHu && logic.canHu(actionPlayer, Consts.CARD_NONE)) {
//						actionPlayer.getActions().add(Consts.ACTION_SELFHU);
						boolean canTianHu=actionPlayer.isCanTianHu();
						System.out.println("========"+(canTianHu?"ACTION_TIANHU":"ACTION_SELFHU"));
//						actionPlayer.getActions().add(canTianHu?ACTION_TIANHU:ACTION_SELFHU);
					
						ShanWeiPlayer swPlayer = (ShanWeiPlayer)actionPlayer;
						// 是天胡且成牌型
						if(canTianHu && swPlayer.isMakePaiXing()){
							if(actionPlayer.equals(gameInfo.getBanker())){
								actionPlayer.getActions().add(ACTION_TIANHU);
							}else{
								//前端修复好之后改成dihu
//								actionPlayer.getActions().add(ACTION_TIANHU);
								if (gameInfo.isCanHuDiHu()&&actionPlayer.isCandihu()) {//牌局能地胡，且玩家能地胡才行
									actionPlayer.getActions().add(Constants.ACTION_DIHU);
								}
								
							}
						}else{
							actionPlayer.getActions().add(ACTION_SELFHU);
						}
						 ((ShanWeiPlayer)actionPlayer).setCanzimohu(true);//过圈是否能胡
				     }
				     else{
				    	 if (logic.getMinRemainCount()>=logic.getRemainCount()) {
				    		context.setSignal(KEY_WINTYPE, WINTYPE_FLOW);
							context.trigger(GAMEFLOW);
							return;
						}
				      ((ShanWeiPlayer)actionPlayer).setCanzimohu(false);
					}
					
					// 最后一张牌不能点炮,直接流局
					if (isOver && !actionPlayer.getActions().contains(Consts.ACTION_SELFHU)) {
						context.setSignal(KEY_WINTYPE, Consts.WINTYPE_FLOW);
						context.trigger(GAMEFLOW);
						return;
					}
					
					List<List<Byte>> tingHuCards4Ting= new ArrayList<>();
					List<Byte> playTingCards4Ting= new ArrayList<>();
					/*
					 * 先查听，后查胡
					 */
					if(!isOver && checkActionInfo.checkTing && logic.canTing(actionPlayer)){//听牌后的提示
//						actionPlayer.getActions().add(Constants.ACTION_HU_TIPS);
						actionPlayer.getActions().add(Consts.ACTION_TING);
						List<TingInfo> tingInfos= actionPlayer.getTingInfos();
						for (TingInfo info : tingInfos) {
							tingHuCards4Ting.add(info.getTingCards());
							playTingCards4Ting.add(info.getPlayForTingCard());
						}
					}
					/*
					 * 能暗杠
					 */
					if (!isOver && checkActionInfo.checkAnGang && logic.canAnGang(actionPlayer)) {
						actionPlayer.getActions().add(Consts.ACTION_ANGANG);
					}
						
					/*
					 * 能加杠
					 */
					if (!isOver && checkActionInfo.checkAddGang && logic.canAddGang(actionPlayer)) {
						actionPlayer.getActions().add(Consts.ACTION_ADDGANG);
						// 能养马
						if (((ShanWeiLogic)logic).canYangMa(actionPlayer)) {
							Iterator it = actionPlayer.getActions().iterator();
							while(it.hasNext()){
								if(it.next().equals(Consts.ACTION_ADDGANG)){
									it.remove();
								}
							}
//							actionPlayer.getActions().remove(Consts.ACTION_ADDGANG);
							actionPlayer.getActions().add(Constants.ACTION_ID_YANGMA);
						}
					}
					
					
					/*
					 * 能养马
					 */
//					if (!isOver && checkActionInfo.checkYangMa && ((ShanWeiLogic)logic).canYangMa(actionPlayer)) {
//						
//						actionPlayer.getActions().add(Constants.ACTION_ID_YANGMA);
//					}
					
					if (actionPlayer.getActions().size() > 0) {
						ShanWeiMMajongPressCardMsg pressCard = new ShanWeiMMajongPressCardMsg();
						List<Byte> actions = actionPlayer.getActions();
						pressCard.setPlayID(playID);
						pressCard.setServertime(System.currentTimeMillis());
						pressCard.setActions(Lists.trans(actions)); // 设置用户特殊操作参数
						pressCard.setNextPlayer(actionPlayer.getUserId()); // 设置用户特殊操作参数
						if (actions.contains(Consts.ACTION_ADDGANG)) {
							pressCard.setAddGangCards(Lists.trans(actionPlayer.getAddGangCards()));
						}
						if (actions.contains(Consts.ACTION_ANGANG)) {
							pressCard.setAnGangCards(Lists.trans(actionPlayer.getAnGangCards()));
						}
						if (actions.contains(Constants.ACTION_ID_YANGMA)) {
							pressCard.setYangMaCards(Lists.trans(((ShanWeiPlayer)actionPlayer).getNoFeeGangCards()));
						}
						
						if (actions.contains(Consts.ACTION_TING)) {
							byte anyCard= 0;
							for (int i = 0; i < tingHuCards4Ting.size(); i++) {
								if (tingHuCards4Ting.get(i).contains(anyCard)) {
									tingHuCards4Ting.set(i, Consts.ALL_CARDS);
								}
							}
							pressCard.setTingHuCards(tingHuCards4Ting);
							pressCard.setTingCards(Lists.trans(playTingCards4Ting));
						}
						
						// 加入十三幺胡牌提示
						List<Byte> jx =  new ArrayList<Byte>(MjHelper.isShiSanYaoCanTing(actionPlayer, actionPlayer.getCloseCards()));
					     if(jx.size()>0)
					      {
					    	   actionPlayer.getActions().add(ACTION_TING);
						       List<Byte> playForTingCards=new ArrayList<>();
						       List<List<Byte>> tingHuCards=new ArrayList<>();
					       for (Byte list : jx) {
						        playForTingCards.add(list);
						        List<Byte> sd = actionPlayer.getCloseCards();
						        sd.remove(list);
						        List<Byte> b =  new ArrayList<Byte>(MjHelper.isTingShiSanYao(actionPlayer, sd));
						        sd.add(list);
						        tingHuCards.add(b);
					       }
					       pressCard.setTingCards(Bytes.trans(playForTingCards));
//					       pressCard.setPlayForTingCards(playForTingCards);
					       pressCard.setTingHuCards(tingHuCards);
					      }
						
						
						pressCard.setPlayID(playID);
						pressCard.setServertime(System.currentTimeMillis());
						pressCard.setActions(Lists.trans(actions)); // 设置用户特殊操作参数
						pressCard.setNextPlayer(actionPlayer.getUserId()); // 设置用户特殊操作参数
						log.debug("playID=" + playID + ",hint action: " + pressCard);
						log.debug("playID=" + playID + ",hint action: " + pressCard);
						sendMessageToPlayerOne(actionPlayer, pressCard);
					}
					
				}
				//等待玩家自己操作
				actionPlayers.add(actionPlayer);
			}
		};
	}
	
	/**
	 * @Descripttion: 杠钱即刻结算,杠的总结算
	 * @author james
	 * @date 2017年4月17日 下午12:08:04
	 * @param gInfo			上下文
	 * @param gangUser		杠的玩家
	 * @param lastPlayUser	被杠的玩家
	 * @param gangTypeId	杠的类型
	 */
	public void calGangScoreNow(BaseFlowGameInfo gInfo, BasePlayer gangUser,
			BasePlayer lastPlayUser, byte gangTypeId) {
		List<PlayerInfo> pList = new ArrayList<PlayerInfo>();
		List<BasePlayer> lost = new ArrayList<BasePlayer>();
		int addScore = 0;
		int lostScore = 0;
		if (gangTypeId == ACTION_CLEARGANG) {
			lost.add(lastPlayUser);
			addScore = 1*(gInfo.getPlayers().size()-1);
			lostScore = -1*(gInfo.getPlayers().size()-1);
		} else {
			List<BasePlayer> tmps = gInfo.getPlayers();
			lost.addAll(tmps);
			lost.remove(gangUser);
			if (gangTypeId == ACTION_ADDGANG) {
				addScore = 1*(gInfo.getPlayers().size()-1);
				lostScore = -1;
			} else if (gangTypeId == ACTION_ANGANG) {
				addScore = 2*(gInfo.getPlayers().size()-1);
				lostScore = -2;
			}
		}
		ShanWeiPlayer swp =(ShanWeiPlayer) gangUser;
		swp.setGangCount(swp.getGangCount()+1);
		gangUser.setScore(gangUser.getScore() + addScore);
		gangUser.setScoreCount(gangUser.getScoreCount() + addScore);
		PlayerInfo p = new PlayerInfo();
		p.setUserId(gangUser.getUserId());
		p.setChangeScorce(addScore);
		p.setScorce(gangUser.getScore());
		pList.add(p);
		for (BasePlayer lostu : lost) {
			lostu.setScore(lostu.getScore() + lostScore);
			lostu.setScoreCount(lostu.getScoreCount() + lostScore);
			p = new PlayerInfo();
			p.setUserId(lostu.getUserId());
			p.setChangeScorce(lostScore);
			p.setScorce(lostu.getScore());
			pList.add(p);
		}
		PrivateRoomScorceChangeMsg changeMsg = new PrivateRoomScorceChangeMsg();
		changeMsg.setPlayers(pList);
		sendMessageToPlayer(Lists.emptyList(), changeMsg);
		// for (long userId : desk.getPlayers()) {
		// GameUser user2 = GameUserManager.getUser(userId);
		// if (user2 != null) {
		// GameMessageSender.out(user2.getRouterServerId(), userId,
		// changeMsg);
		// }
		// }
	}
	
	
	public ContextHandler<MajongContext> addGangExecute() {
		return new ContextHandler<MajongContext>() {
			@Override
			public void call(MajongContext context) throws Exception {
				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				log.info("playID  = " + playID + " 处理加杠,养马:" + action+" start");
				BaseFlowGameInfo gameInfo=context.getGameInfo();
				BasePlayer player=gameInfo.getLastPlayer();
				
				byte actionCard = gameInfo.getLastPlayCard();
				Byte temp1=Byte.valueOf(actionCard+"");
				
				if (action.getActionID()==4) {
					gameInfo.setGangCount(gameInfo.getGangCount()+1);
					player.setAddGangCount(player.getAddGangCount()+1);;
					List<Byte> temp2=Lists.make(temp1,temp1,temp1);
					for(OpenCard openCard:player.getOpenCards()){
						if(openCard.getOpenCards().equals(temp2)){
							openCard.getOpenCards().add(temp1);
							openCard.setOpenCardsType(ACTION_ADDGANG);
							break;
						}
					}
				}
				
				if (action.getActionID()==94) {
					List<Byte> temp2=Lists.make(temp1,temp1,temp1);
					for(OpenCard openCard:player.getOpenCards()){
						if(openCard.getOpenCards().equals(temp2)){
							openCard.getOpenCards().add(temp1);
							openCard.setOpenCardsType(Constants.ACTION_ID_YANGMA);
							break;
						}
					}
				}
				
//				player.getCloseCards().remove(Byte.valueOf(actionCard));//5.19
				
				if(gameInfo.isGang()) gameInfo.setGangOnGang(true);
				gameInfo.setGang(true);
				gameInfo.setInLoopGang(false);//5.19
				//5.19 补发加杠
				gameInfo.getPlayers().forEach(
					p->{
						//加杠
						if(p.isResumeInLoopGang()&&action.getActionID()==4){
							MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
							sendAction.setUserID(player.getUserId());
							sendAction.setActionID(ACTION_ADDGANG);
							sendAction.setActionResult(1);
							sendAction.setActionCard(actionCard);
							sendAction.setCbCards(new byte[]{actionCard,actionCard,actionCard,actionCard});
							sendAction.setServertime(System.currentTimeMillis());
							sendMessageToPlayerOne(p, sendAction);
							p.setResumeInLoopGang(false);
						}
						//养马
						if(p.isResumeInLoopGang()&&action.getActionID()==94){
							MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
							sendAction.setUserID(player.getUserId());
							sendAction.setActionID(Constants.ACTION_ID_YANGMA);
							sendAction.setActionResult(1);
							sendAction.setActionCard(actionCard);
							sendAction.setCbCards(new byte[]{actionCard,actionCard,actionCard,actionCard});
							sendAction.setServertime(System.currentTimeMillis());
							sendMessageToPlayerOne(p, sendAction);
							p.setResumeInLoopGang(false);
						}
					}
				);
				
//				player.getActions().clear();
				gameInfo.getActionPlayers().add(player);
				context.setSignal(KEY_NEED_DRAW_CARD, true);
				context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());
			
			}
		};
	}
	
	/**
	 * @Descripttion: 增加杠立马算分的逻辑
	 * @author james
	 * @date 2017年5月31日 下午5:59:24
	 * @return
	 */
//	public ContextHandler<MajongContext> addGangExecute() {
//		return new ContextHandler<MajongContext>() {
//			@Override
//			public void call(MajongContext context) throws Exception {
//				MMajongGameActionMsg action=context.getAction();
//				checkArgument(action!=null, "action null");
//				log.info("playID  = " + playID + " 处理加杠:" + action+" start");
//				BaseFlowGameInfo gameInfo=context.getGameInfo();
//				BasePlayer player=gameInfo.getLastPlayer();
//				
//				byte actionCard = gameInfo.getLastPlayCard();
//				gameInfo.setGangCount(gameInfo.getGangCount()+1);
//				player.setAddGangCount(player.getAddGangCount()+1);;
//				Byte temp1=Byte.valueOf(actionCard+"");
//				List<Byte> temp2=Lists.make(temp1,temp1,temp1);
//				for(OpenCard openCard:player.getOpenCards()){
//					if(openCard.getOpenCards().equals(temp2)){
//						openCard.getOpenCards().add(temp1);
//						openCard.setOpenCardsType(ACTION_ADDGANG);
//						break;
//					}
//				}
//				player.getCloseCards().remove(Byte.valueOf(actionCard));
//				
//				if(gameInfo.isGang()) gameInfo.setGangOnGang(true);
//				calGangScoreNow(getGameInfo(), player, getGameInfo().getLastPlayer(), ACTION_ADDGANG);
//				gameInfo.setGang(true);
//				gameInfo.setInLoopGang(false);//5.19
//				//5.19 补发加杠
//				gameInfo.getPlayers().forEach(
//						p->{
//							if(p.isResumeInLoopGang()){
//								MMajongGameActionMsg sendAction = new MMajongGameActionMsg();
//								sendAction.setUserID(player.getUserId());
//								sendAction.setActionID(ACTION_ADDGANG);
//								sendAction.setActionResult(1);
//								sendAction.setActionCard(actionCard);
//								sendAction.setCbCards(new byte[]{actionCard,actionCard,actionCard,actionCard});
//								sendAction.setServertime(System.currentTimeMillis());
//								sendMessageToPlayerOne(p, sendAction);
//								p.setResumeInLoopGang(false);
//							}
//						}
//						);
////				player.getActions().clear();
//				gameInfo.getActionPlayers().add(player);
//				context.setSignal(KEY_NEED_DRAW_CARD, true);
//				context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());
//			}
//		};
//	}
	
	/**
	 * @Descripttion: 增加杠立马算分的逻辑
	 * @author james
	 * @date 2017年5月31日 下午4:22:01
	 * @return
	 */
//	public ContextHandler<MajongContext> anGangExecute() {
//		return new ContextHandler<MajongContext>() {
//			@Override
//			public void call(MajongContext context) throws Exception {
//				MMajongGameActionMsg action=context.getAction();
//				checkArgument(action!=null, "action null");
//				int actionResult = action.getActionResult();
//				BasePlayer player=getGameInfo().getPlayer(action.getUserID());
//				getGameInfo().getActionPlayers().add(player);
//				if(actionResult==0){
//					context.setSignal(KEY_NEED_DRAW_CARD, false);
////					context.setSignal(KEY_NEED_HINT_ACTION, false);
//					context.trigger(NO);
//				}else{
//					calGangScoreNow(getGameInfo(), player, getGameInfo().getLastPlayer(), ACTION_ANGANG);
//					context.setSignal(KEY_NEED_DRAW_CARD, true);
//					context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());
//					context.trigger(YES);
//				}
//			}
//		};
//	}
	
	public ContextHandler<MajongContext> anGangExecute() {
		return new ContextHandler<MajongContext>() {
			@Override
			public void call(MajongContext context) throws Exception {
				MMajongGameActionMsg action=context.getAction();
				checkArgument(action!=null, "action null");
				int actionResult = action.getActionResult();
				BasePlayer player=getGameInfo().getPlayer(action.getUserID());
				getGameInfo().getActionPlayers().add(player);
				if(actionResult==0){
					context.setSignal(KEY_NEED_DRAW_CARD, false);
//					context.setSignal(KEY_NEED_HINT_ACTION, false);
					context.trigger(NO);
				}else{
					ShanWeiGameInfo shanWeiGameInfo=(ShanWeiGameInfo)getGameInfo();
					shanWeiGameInfo.setCanHuDiHu(false);//有碰杠，牌局不能在胡地胡
					context.setSignal(KEY_NEED_DRAW_CARD, true);
					context.setSignal(KEY_NEED_HINT_ACTION, CheckActionInfo.builder().build());
					context.trigger(YES);
				}
			}
		};
	}
	
	/**
     * 总结算-消息
     */
    protected BaseMsg totalSettleMsg(int roomFeeSum, Map<Long, Integer> certificate) {
        BaseFlowGameInfo gameInfo = getGameInfo();
        int roomJieSuanType = desk.getSetting().getCustemConf().getRoomJieSuanType();
        PrivateRoomRankAwardMsg awardMsg = new PrivateRoomRankAwardMsg();
        for (BasePlayer player : gameInfo.getPlayers()) {
			ShanWeiPlayer swPlayer=(ShanWeiPlayer) player;
			
			ShanWeiPlayInfo info = new ShanWeiPlayInfo();
			UUserInfo uuerInfo = GameUserManager.getUserInfo(player.getUserId());
			
			info.setUserId(swPlayer.getUserId());
			info.setHeadImgURL(uuerInfo.getImgId());
			info.setNickName(uuerInfo.getNickName());
			info.setHusum(swPlayer.getHuCount());
			info.setZmc(swPlayer.getZimoCount());
			info.setDpc(swPlayer.getDiaopaoCount());
			info.setFc(swPlayer.getFlowerCount());
//			info.setTotalscore(player.getScore());
			
//			ShanWeiPlayer swp = (ShanWeiPlayer)player;
//			info.setBugangcount(swp.getBugangcount());
//			info.setAnagangcount(swp.getAnagangcount());
//			info.setZhigangcount(swp.getZhigangcount());
			
			info.setGangsum(swPlayer.getBugangcount()+swPlayer.getAnagangcount()+swPlayer.getZhigangcount());
			info.setQiangGangSum(swPlayer.getQghcount());
			info.setGangKaiSum(swPlayer.getGangKaiSum());
//			info.setBqghcount(swp.getBqghcount());
			info.setTotalscore(swPlayer.getScoreCount());
			info.setRoomFeeSum(swPlayer.getRoomFee());
			info.setRoomJieSuanType(roomJieSuanType);
			info.setFc(swPlayer.getFlowerCount());
			
			if (certificate.get(player.getUserId()) != null) {
                info.setWinnerAward(certificate.get(player.getUserId()));
            }
			
			awardMsg.addPlayerList(info);
		}
        awardMsg.setTotalRoomFee(roomFeeSum);
        return awardMsg;
    }
	
	/*@Override
	protected void totalSettle() {
		BaseFlowGameInfo gameInfo=getGameInfo();
		SPrivateroomInfo roomCache=desk.getSetting().getCustemConf();
		int roomJieSuanType=roomCache.getRoomJieSuanType();
		long ownerId=desk.getSetting().getCustemConf().getOwnerId();
		int roomId=Ints.checkedCast(desk.getSetting().getRoomId());
		int roomFeeSum=desk.getSetting().getCustemConf().getRoomFeeSum();
		
		*//**扣钻石**//*
		if (gameInfo.getRound()>=1 && !RoomFeeConfigHelper.isRoomFeeFree(System.currentTimeMillis())) {
			// 付费玩家集合
			List<BasePlayer> fuFeiUserList = new ArrayList<BasePlayer>();
			if(roomJieSuanType==1){//房主付费
//				long ownerId=roomCache.getOwnerId();
				fuFeiUserList.add(gameInfo.getPlayer(ownerId));
			}
			if(roomJieSuanType==2){//大赢家付
				long max=Integer.MIN_VALUE;
				for(BasePlayer player:gameInfo.getPlayers()){
					long score=player.getScore();
					if(score>max){
						fuFeiUserList.clear();
						fuFeiUserList.add(player);
						max=score;
					}else if(score==max){
						fuFeiUserList.add(player);
					}
				}
			}
			if(roomJieSuanType==3){//AA付
				fuFeiUserList.addAll(gameInfo.getPlayers());
			}
			if(fuFeiUserList.size()>0){
				int roomFee = (int)Math.ceil(roomCache.getRoomFeeSum()*1.0/fuFeiUserList.size());
				for(BasePlayer player : fuFeiUserList ){
					//给玩家赋房费数的值
//					RoomPlayerDB roomPlayerDB = roomCache.getRoomPlayers().get(userId);
//					roomPlayerDB.setRoomFeeSum(roomFeeSum);
					long userId=player.getUserId();
//					player.setScoreCount(player.getScoreCount()+player.getScoreDiff());
					player.setRoomFee(player.getRoomFee()+roomFee);
					GameUser ownerUser = GameUserManager.getUser(userId);
					UUserPoint point = GameUserManager.getUserPointInfo(userId);
					UUserInfo userInfo = GameUserManager.getUserInfo(userId);
					long before = point.getPrivateRoomDiamond();
					point.preUpdate();
					point.updatePrivateRoomDiamond(point.getPrivateRoomDiamond() - roomFee);
					if (new UUserPointDaoImplPro().addUUserPointPrivateDiamond(point.getUserId(),- roomFee)) {
						point.save();
						MessageHelper.updateData(ownerUser.getRouterServerId(), ownerUser.getUserId(), UserDataConst.USER_POINT_CODE, point);
						LoggerWriter.addPropDiffLog(userInfo.getUserId(), userInfo.getNickName(),roomId, point.getPrivateRoomGameId(), before, point.getPrivateRoomDiamond(),roomFee, ItemConfig.ITEM_ID_PYJ_DIAMOND, 100);
					}
				}
			}
		}else {// 10.23
            roomFeeSum = 0;
        }
		
//		for(BasePlayer player:gameInfo.getWinners()){
//			ShanWeiPlayer swPlayer=(ShanWeiPlayer) player;
//			BaseLogic logicBase = getLogic();
//			ShanWeiLogic logic = (ShanWeiLogic)logicBase;
//			swPlayer.setGangKaiSum(logic.calcGangFlower(swPlayer));
//		}
		
		*//**计算大赢家奖励**//*
        HashMap<Long, Integer> certificate = countCertificate(desk.getSetting().getCustemConf());
		*//**总结算**//*
//		if(gameInfo.getRound()==gameInfo.getTotalRound()){
			PrivateRoomRankAwardMsg awardMsg = new PrivateRoomRankAwardMsg();
			for(BasePlayer player:gameInfo.getPlayers()){
				ShanWeiPlayer swPlayer=(ShanWeiPlayer) player;
				
				ShanWeiPlayInfo info = new ShanWeiPlayInfo();
				UUserInfo uuerInfo = GameUserManager.getUserInfo(player.getUserId());
				
				info.setUserId(swPlayer.getUserId());
				info.setHeadImgURL(uuerInfo.getImgId());
				info.setNickName(uuerInfo.getNickName());
				info.setHusum(swPlayer.getHuCount());
				info.setZmc(swPlayer.getZimoCount());
				info.setDpc(swPlayer.getDiaopaoCount());
				info.setFc(swPlayer.getFlowerCount());
//				info.setTotalscore(player.getScore());
				
//				ShanWeiPlayer swp = (ShanWeiPlayer)player;
//				info.setBugangcount(swp.getBugangcount());
//				info.setAnagangcount(swp.getAnagangcount());
//				info.setZhigangcount(swp.getZhigangcount());
				
				info.setGangsum(swPlayer.getBugangcount()+swPlayer.getAnagangcount()+swPlayer.getZhigangcount());
				info.setQiangGangSum(swPlayer.getQghcount());
				info.setGangKaiSum(swPlayer.getGangKaiSum());
//				info.setBqghcount(swp.getBqghcount());
				info.setTotalscore(swPlayer.getScoreCount());
				info.setRoomFeeSum(swPlayer.getRoomFee());
				info.setRoomJieSuanType(roomJieSuanType);
				info.setFc(swPlayer.getFlowerCount());
				
				if (certificate.get(player.getUserId()) != null) {
                    info.setWinnerAward(certificate.get(player.getUserId()));
                }
				
				awardMsg.addPlayerList(info);
			}
			// 10.23
			awardMsg.setTotalRoomFee(roomFeeSum);
			log.info("总结算: "+awardMsg);
			for(BasePlayer player:gameInfo.getPlayers()){
				GameMessageSender.out(player.getRouter(), player.getUserId(), awardMsg);
//				sendMessageToPlayerOne(player, awardMsg);
				
				log.info(awardMsg.getPlayerList().get(0).getNickName()+"=====================胡牌次数"+awardMsg.getPlayerList().get(0).getHusum());
				log.info(awardMsg.getPlayerList().get(0).getNickName()+"=====================自摸次数"+awardMsg.getPlayerList().get(0).getZmc());
				//log.info(awardMsg.getPlayerList().get(0).getNickName()+"=====================杠开次数"+awardMsg.getPlayerList().get(0).getgangk());
			}
//		}
	}*/
	
//	public void bindEvents() {
//		
//	}
	/**不必要的重写*/
//	public HashMap<Long, Integer> countCertificate(SPrivateroomInfo roomCache){
//        HashMap<Long, Integer> result =new HashMap<Long, Integer>(); 
//        BaseFlowGameInfo gameInfo=getGameInfo();
//        try{
//            if (gameInfo.getRound()>=1){
//                SConfig config= SysConfig.getInstance().getCfg("coin_certificate");
//                if(config!=null){
//                    
//                    int CertificatePer=0;
//                    int minValue=0;
//                    int maxValue=0;
//                    String[] playerNumPer;
//                    String[] roundCertificate;
//                    String[] coinCertificate = config.getSValue().split("\\$");
//                    if(coinCertificate !=null && coinCertificate.length == 2){
//                        playerNumPer =coinCertificate[0].split("\\|");
//                        roundCertificate =coinCertificate[1].split("\\|");
//                        
//                        for(String p : playerNumPer){
//                            String[] ps = p.split(":");
//                            if(ps!=null && ps.length==2 && (Integer.parseInt(ps[0]) == gameInfo.getPlayers().size())){
//                                CertificatePer=Integer.parseInt(ps[1]);
//                                break;
//                            }
//                        }
//                        
//                        for(String r:roundCertificate){
//                            String[] rc = r.split(":");
//                            if(rc!=null && rc.length==2 && (Integer.parseInt(rc[0]) == desk.getSetting().getCustemConf().getRoundSum())){
//                                String[] certificate=rc[1].split("~");
//                                if(certificate !=null && certificate.length==2 ){
//                                    minValue = Integer.parseInt(certificate[0]);
//                                    maxValue = Integer.parseInt(certificate[1]);
//                                }
//                                break;
//                            }
//                        }
//                    }
//                    if(CertificatePer >0 && minValue >0 && maxValue> minValue  ){
//                        // 大赢家集合
//                        List<BasePlayer> winnerUserList = new ArrayList<>();
//                        long max=Integer.MIN_VALUE;
//                        for(BasePlayer player:gameInfo.getPlayers()){
//                            long score=player.getScore();
//                            if(score>max){
//                                winnerUserList.clear();
//                                winnerUserList.add(player);
//                                max=score;
//                            }else if(score==max){
//                                winnerUserList.add(player);
//                            }
//                        }
//                        
//                        Random random = new Random();
//                        int randomNum= minValue + random.nextInt(maxValue-minValue);
//                        //存在大赢家， 且大赢家人数不等于玩家人数
//                        if(winnerUserList.size()>0 && winnerUserList.size() != gameInfo.getPlayers().size()){
//                            //计算奖励的兑换券，算法: 期间随机数*人数对应的比率/100*(当前局数/总局数)/大赢家人数  ，再 结果向下取整
//                            int awardNum = (int)Math.floor(1.0 *randomNum * CertificatePer / 100 * (1.0*gameInfo.getRound()/desk.getSetting().getCustemConf().getRoundSum()) / winnerUserList.size());
//                            for(BasePlayer player : winnerUserList ){
//                                long userId=player.getUserId();
//                              //  ((ShangQiuPlayer)player).setWinnerAward(awardNum);
//                                result.put(userId, awardNum);
//                                
//                                GameUser ownerUser = GameUserManager.getUser(userId);
//                                UUserPoint point = GameUserManager.getUserPointInfo(userId);
//                                UUserInfo userInfo = GameUserManager.getUserInfo(userId);
//                                long before = point.getPaper();
//                                point.preUpdate();
//                                point.updatePaper(point.getPaper()+ awardNum);
//                                if (new UUserPointDaoImplPro().addUUserPointPaper(point.getUserId(),awardNum)) {
//                                    point.save();
//                                    MessageHelper.updateData(ownerUser.getRouterServerId(), ownerUser.getUserId(), UserDataConst.USER_POINT_CODE, point);
////                                    LoggerWriter.addPropDiffLog(userInfo.getUserId(), userInfo.getNickName(),roomCache.getRoomId(), point.getPrivateRoomGameId(), before, point.getPaper(),awardNum, ItemConfig.ITEM_ID_PAPER, 110);//改
//                                    LoggerWriter.addPropDiffLog(userInfo.getUserId(), userInfo.getNickName(),roomCache.getRoomId(), point.getPrivateRoomGameId(), 
//                                    		desk.getSetting().getGameId(),before, point.getPaper(),awardNum, ItemConfig.ITEM_ID_PAPER, 110);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }catch(Exception e) {
//            log.error("生成大赢家兑换券报错");
//            e.printStackTrace();
//        }
//        
//        return result;
//        
//    }
	
	//吃碰杠胡
	@Override
		protected List<BasePlayer> checkAction(byte actionCard, List<BasePlayer> players,boolean checkHu,boolean checkPG,boolean checkChi){
			log.info("playID = " + playID +" actionCard = " + actionCard + " checkAction nPlayers =" + players);
			byte[][] actions=new byte[players.size()][0];
			boolean hasHu=false;
			boolean hasPG=false;
			boolean hasC=false;
			for(int i=0;i<players.size();i++){
				BasePlayer p=players.get(i);
				p.getActions().clear();
//				p.actions=new byte[0];
				boolean cannotHu=p.getCannotHuCard().contains(Byte.valueOf(actionCard)) || !p.isCanHu();//臭字
//				if(!isChouZi){
					if(checkHu && !cannotHu && getLogic().canHu(p, actionCard)&&(!((ShanWeiPlayer)p).isCanzimohu())){
				          Byte actionId=changeActionId_Hu((ShanWeiPlayer)p);//判断是地胡还是胡
		                  actions[i]=Bytes.concat(actions[i],new byte[]{actionId});
//						actions[i]=Bytes.concat(actions[i],new byte[]{ACTION_HU});
						hasHu=true;
						log.info("playID = " + playID +" can hu ! players: "+p+" closecards: "+p.getCloseCards());
					}
					if(checkPG && getLogic().canPeng(p, actionCard)){
						actions[i]=Bytes.concat(actions[i],new byte[]{Consts.ACTION_PENG});
						hasPG=true;
					}
					if(checkPG && getLogic().canClearGang(p,actionCard)){
						actions[i]=Bytes.concat(actions[i],new byte[]{ACTION_CLEARGANG});
						hasPG=true;
					}
					if(checkChi && getLogic().canChi(p, actionCard)){
						actions[i]=Bytes.concat(actions[i],new byte[]{Consts.ACTION_CHI});
						hasC=true;
					}
//				}
			}
			//胡>杠/碰>吃
			List<BasePlayer> ret=new ArrayList<>(4);
			if(hasHu){
				boolean suportMutiHu = getLogic().isSuportMutiHu();
				for(int i=0;i<actions.length;i++){
					ShanWeiPlayer p=(ShanWeiPlayer)players.get(i);
					byte[] _actions=actions[i];
					if(Bytes.contains(_actions, ACTION_HU) ||Bytes.contains(_actions, Constants.ACTION_DIHU_DIANPAO)){
						ret.add(p);
						/*if (getGameInfo().isGang()) {
						p.getActions().add(getGameInfo().isGang()?ACTION_GANGHOUPAO:ACTION_HU);
						}*/
						log.info("=====================庄家是："+getGameInfo().getBanker());
						
//						p.getActions().add(p.isCanTianHu()?ACTION_TIANHU_DIANPAO:ACTION_HU);
//						p.getActions().add((p.isCanTianHu() && !getGameInfo().getBanker().equals(p))?Constants.ACTION_DIHU:ACTION_HU);
					//TODOXSDFSDF  需要修改  如果闲给闲点炮，也不是地胡
						ShanWeiGameInfo shanWeiGameInfo=(ShanWeiGameInfo)getGameInfo();
						if(shanWeiGameInfo.isCanHuDianPaoDiHu()&&p.isCandihu()) {//点炮地胡
							p.getActions().add(Constants.ACTION_DIHU_DIANPAO);
						}else {
							p.getActions().add(ACTION_HU);
						}
						log.info("=-=-=-=-=-=-=p是"+p.getUserId());
						
//						if (p.isCanTianHu() && !getGameInfo().getBanker().equals(p)) {
//							p.getActions().add(Constants.ACTION_DIHU_DIANPAO);
//						}
						
						if(!suportMutiHu){
							getGameInfo().setCanHuCount(1);;
							return ret;
						}
					}
				}
				getGameInfo().setCanHuCount(ret.size());
			}else if(hasPG){
				for(int i=0;i<actions.length;i++){
					BasePlayer p=players.get(i);
					byte[] _actions=actions[i];
					boolean canG=Bytes.contains(_actions, Consts.ACTION_CLEARGANG);
					boolean canP=Bytes.contains(_actions, Consts.ACTION_PENG);
					if(canG || canP) ret.add(p);
					if(Bytes.contains(_actions, ACTION_CLEARGANG)){
						p.getActions().add(ACTION_CLEARGANG);
					}
					if(Bytes.contains(_actions,Consts.ACTION_PENG)){
						p.getActions().add(Consts.ACTION_PENG);
					}
					if(i==0){
						boolean canC=Bytes.contains(_actions,Consts. ACTION_CHI);
						if(canC){
							p.getActions().add(Consts.ACTION_CHI);
						}
					}
				}
			}else if(hasC){
				BasePlayer p=players.get(0);
				byte[] _actions=actions[0];
				if(Bytes.contains(_actions, Consts.ACTION_CHI)){
					ret.add(p);
					p.getActions().add(Consts.ACTION_CHI);
				}
			}
			return ret;
		}
	
	
    private Byte changeActionId_Hu(ShanWeiPlayer shanWeiPlayer) {
        Byte actionId=ACTION_HU;
        boolean canHuDiHuFlag=shanWeiPlayer.isCandihu();//牌局能否胡地胡的状态
        boolean canHuDianPaoDiHu=((ShanWeiGameInfo)getGameInfo()).isCanHuDianPaoDiHu();
        if (canHuDiHuFlag&&canHuDianPaoDiHu) {//玩家能胡地胡，且牌局能胡点炮地胡
            actionId=Constants.ACTION_DIHU_DIANPAO;//地胡点炮
        }else {
                actionId=ACTION_HU;
        }
        return actionId;
    }
    
	public static class CheckActionInfo {
		boolean checkSelfHu;
		boolean checkTing;
		boolean checkAnGang;
		boolean checkAddGang;
		boolean checkYangMa;

		private CheckActionInfo(Builder builder) {
			this.checkAddGang = builder.checkAddGang;
			this.checkAnGang = builder.checkAnGang;
			this.checkSelfHu = builder.checkSelfHu;
			this.checkTing = builder.checkTing;
			this.checkYangMa = builder.checkYangMa;
		}

		public static Builder builder() {
			return new Builder();
		}

		public static final class Builder {
			private boolean checkSelfHu = true;
			private boolean checkTing = true;
			private boolean checkAnGang = true;
			private boolean checkAddGang = true;
			private boolean checkYangMa = true;

			private Builder() {
			}

			public Builder checkSelfHu(boolean checkSelfHu) {
				this.checkSelfHu = checkSelfHu;
				return this;
			}

			public Builder checkTing(boolean checkTing) {
				this.checkTing = checkTing;
				return this;
			}

			public Builder checkAnGang(boolean checkAnGang) {
				this.checkAnGang = checkAnGang;
				return this;
			}

			public Builder checkAddGang(boolean checkAddGang) {
				this.checkAddGang = checkAddGang;
				return this;
			}
			
			public Builder checkYangMa(boolean checkYangMa) {
				this.checkYangMa = checkYangMa;
				return this;
			}

			public CheckActionInfo build() {
				return new CheckActionInfo(this);
			}
		}
	}
	
}
