package com.dszy.game.gamelogic.majong.shanwei;

import static com.dszy.game.gamelogic.majong.data.Consts.CARDTYPE_ADDGANG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARDTYPE_ANGANG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARDTYPE_CLEARGANG;
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
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_CHUN;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_DONG;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_JU;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_LAN;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_MEI;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_QIU;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_XIA;
import static com.dszy.game.gamelogic.majong.data.Consts.FLOWER_ZHU;
import static com.dszy.game.gamelogic.majong.data.Consts.RESULT_BUREAU;
import static com.dszy.game.gamelogic.majong.data.Consts.WINTYPE_FLOW;
import static com.dszy.game.gamelogic.majong.data.Consts.WINTYPE_HU;
import static com.dszy.game.gamelogic.majong.data.Consts.WINTYPE_LOOP_GANG;
import static com.dszy.game.gamelogic.majong.data.Consts.WINTYPE_SELF_HU;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.dszy.game.gamelogic.Desk;
import com.dszy.game.gamelogic.majong.data.Consts;
import com.dszy.game.gamelogic.majong.gameinfo.BaseFlowGameInfo;
import com.dszy.game.gamelogic.majong.logic.BaseLogic;
import com.dszy.game.gamelogic.majong.player.BasePlayer;
import com.dszy.game.gamelogic.majong.player.BasePlayer.Fan;
import com.dszy.game.gamelogic.majong.player.BasePlayer.OpenCard;
import com.dszy.game.gamelogic.majong.shanwei.utils.HuHelper;
import com.dszy.game.gamelogic.majong.shanwei.utils.MjHelper;
import com.dszy.game.gamelogic.majong.utils.ComplexHu;
import com.dszy.game.gamelogic.majong.utils.ComplexHu.Pattern;
import com.dszy.game.gamelogic.majong.utils.Hu;
import com.dszy.game.gamelogic.majong.utils.Hu.HuStrategy;
import com.dszy.game.gamelogic.majong.utils.Hu.TingInfo;
import com.dszy.game.gamelogic.majong.utils.Hus;
import com.dszy.game.gamelogic.majong.utils.Lists;
import com.dszy.game.log.Logger;
import com.dszy.game.log.LoggerFactory;
import com.google.common.collect.ImmutableList;

public class ShanWeiLogic extends BaseLogic {
	
	final transient static Logger log = LoggerFactory.getLogger(ShanWeiLogic.class);
	
	private static final Fan FAN_QGH = new Fan("抢杠胡", 1);
	private static final Fan FAN_TDH = new Fan("鸡胡", 2);
	private static final Fan FAN_ZM = new Fan("自摸", 1);
	private static final Fan FAN_HDLY = new Fan("海底捞月", 2);
	private static final Fan FAN_GSKH = new Fan("杠上开花", 2);
	private static final Fan FAN_QYSZMHU = new Fan("清一色自摸胡", 2);
	
	public final static byte CARDTYPE_YANGMA = 94;
	
	
//	//十三幺可抢杠胡
//	public static final String WF_SHISANYAO_QGH = "shisanyaokeqiangganghu";
//	
//	//抢杠胡无马
//	public static final String WF_QIANGGANGH_WM = "qiangganghuwuma";
//	
//	//无花算一花
//	public static final String WF_WUH_ONE = "wuhuasuanyifa";
	
	public static final List<Byte> HZ_ALL_CARDS=ImmutableList.of(
    		CARD_1WAN,CARD_2WAN,CARD_3WAN,CARD_4WAN,CARD_5WAN,CARD_6WAN,CARD_7WAN,CARD_8WAN,CARD_9WAN,
    		CARD_1TIAO,CARD_2TIAO,CARD_3TIAO,CARD_4TIAO,CARD_5TIAO,CARD_6TIAO,CARD_7TIAO,CARD_8TIAO,CARD_9TIAO,
    		CARD_1TONG,CARD_2TONG,CARD_3TONG,CARD_4TONG,CARD_5TONG,CARD_6TONG,CARD_7TONG,CARD_8TONG,CARD_9TONG,
    		CARD_DONG,CARD_NAN,CARD_XI,CARD_BEI,CARD_ZHONG,CARD_FA,CARD_BAI,
    		FLOWER_CHUN,FLOWER_XIA,FLOWER_QIU,FLOWER_DONG,FLOWER_MEI,FLOWER_LAN,FLOWER_JU,FLOWER_ZHU);
	
	
	/*
	 * 初始化洗牌
	 * (non-Javadoc)
	 * @see com.dszy.game.gamelogic.majong.logic.BaseLogic#initWall()
	 */
	@Override
	public void initWall() {
		List<Byte> wall=gameInfo.getCards();
		byte[] wanpai=new byte[]{CARD_1WAN,CARD_2WAN,CARD_3WAN,CARD_4WAN,CARD_5WAN,CARD_6WAN,CARD_7WAN,CARD_8WAN,CARD_9WAN};
		for(byte card:wanpai){
			wall.add(card);
			wall.add(card);
			wall.add(card);
			wall.add(card);
		}
		byte[] tiaopai=new byte[]{CARD_1TIAO,CARD_2TIAO,CARD_3TIAO,CARD_4TIAO,CARD_5TIAO,CARD_6TIAO,CARD_7TIAO,CARD_8TIAO,CARD_9TIAO};
		for(byte card:tiaopai){
			wall.add(card);
			wall.add(card);
			wall.add(card);
			wall.add(card);
		}
		byte[] tongpai=new byte[]{CARD_1TONG,CARD_2TONG,CARD_3TONG,CARD_4TONG,CARD_5TONG,CARD_6TONG,CARD_7TONG,CARD_8TONG,CARD_9TONG};
		for(byte card:tongpai){
			wall.add(card);
			wall.add(card);
			wall.add(card);
			wall.add(card);
		}
		byte[] zipai=new byte[]{CARD_DONG,CARD_NAN,CARD_XI,CARD_BEI,CARD_ZHONG,CARD_FA,CARD_BAI};
		for(byte card:zipai){
			wall.add(card);
			wall.add(card);
			wall.add(card);
			wall.add(card);
		}
		byte[] huapai=new byte[] {FLOWER_CHUN,FLOWER_XIA,FLOWER_QIU,FLOWER_DONG,FLOWER_MEI,FLOWER_LAN,FLOWER_JU,FLOWER_ZHU};
		for(byte card:huapai){
			wall.add(card);
		}
		Collections.shuffle(wall);
	}
	
	//设定流庄牌数
	private int minRemainCount=0;
	
	/*
	 * 原理介绍：黄庄墩数计算
	 * (non-Javadoc)
	 * @see com.dszy.game.gamelogic.majong.logic.BaseLogic#getMinRemainCount()
	 */
	@Override
	public int getMinRemainCount() {
		int minRemainCount = 0;
//		if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MATYPE_JIANGMA)) {
		if(countJiangMa()>0) {
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_JIANGMA_2)) {
				minRemainCount = 2;
			}
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_JIANGMA_4)) {
				minRemainCount = 4;
			}
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_JIANGMA_6)) {
				minRemainCount = 6;
			}
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_JIANGMA_8)) {
				minRemainCount = 8;
			}
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_JIANGMA_10)) {
				minRemainCount = 10;
			}
		}		
		return minRemainCount;
	}


//	public int setMinRemainCount(int minRemainCount) {
//		return this.minRemainCount = minRemainCount;
//	}
	
	//买马的时候只有在游戏开局 也就是第一局的时候才会买马   设置买马的局数  初始化局数 
	/**
	 * 开局前买马，任何人都可以买，也可以不买。买了就要一直买，
	 * 直到结束或者不玩了，开局发完牌后，先把买马的牌按照买的数量发给所有人
	 * ，从庄家，下家，对家，上家的顺序发放，然后扣着先不看，发出来的牌不算正常牌序里的牌。
	 */
//	@Override
//	public byte[] getXiaPaoList() {
//		// TODO Auto-generated method stub
//		return gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MATYPE_MAIMA)&&gameInfo.getRound()==0? new byte[]{0,1}:null;
//	}

	  /**
     * 买马只能买1马或者是2马 传给前端的是1和2  return 3是不选买马 
     */
//	@Override
//	public byte getDplzType() {
//		// TODO Auto-generated method stub
//		return 3;
//	}
	
	/*
	 * 汕尾麻将不能吃
	 * (non-Javadoc)
	 * @see com.dszy.game.gamelogic.majong.logic.BaseLogic#canChi(com.dszy.game.gamelogic.majong.player.BasePlayer, byte)
	 */
	
	@Override
	public boolean canChi(BasePlayer checkedPlayer, byte actionCard) {
		return false;
	}
	
	@Override//直杠
	public boolean canClearGang(BasePlayer checkedPlayer, byte actionCard) {
		return super.canClearGang(checkedPlayer, actionCard);
	}

	@Override//加杠
	public boolean canAnGang(BasePlayer checkedPlayer) {
		return super.canAnGang(checkedPlayer);
	}

	@Override//补杠
	public boolean canAddGang(BasePlayer checkedPlayer) {
		return super.canAddGang(checkedPlayer);
	}
	
	/*
	 * 是否可以碰，直接调用父类即可，碰的逻辑是通用的
	 * (non-Javadoc)
	 * @see com.dszy.game.gamelogic.majong.logic.BaseLogic#canPeng(com.dszy.game.gamelogic.majong.player.BasePlayer, byte)
	 */
	
	@Override
	public boolean canPeng(BasePlayer checkedPlayer, byte actionCard) {
		return !checkedPlayer.getCannotPengCard().contains(actionCard) && super.canPeng(checkedPlayer, actionCard);
	}
	
	public boolean canTing(ShanWeiLogic logic, ShanWeiPlayer checkedPlayer) {
		ShanWeiGameInfo swGameInfo= (ShanWeiGameInfo)this.gameInfo;
		List<Byte> checkedCards= new ArrayList<>(checkedPlayer.getCloseCards());
		List<Byte>  laizies= new ArrayList<>();
		laizies.add(swGameInfo.getLaizi());
		
//		List<TingInfo> checkedResult= HuHelper.checkTing(checkedCards, laizies, swGameInfo.getHuStrategys());
		List<TingInfo> checkedResult= HuHelper.checkTing(checkedCards, laizies, swGameInfo.getHuStrategys());
		checkedPlayer.setTingInfos(checkedResult);
		return !checkedResult.isEmpty();
	}
	
	@Override
	public boolean canTing(BasePlayer checkedPlayer) {
		if(checkedPlayer.isTing()) return false;
		List<Byte> laizies=new ArrayList<>();
		laizies.add(gameInfo.getLaizi());
		List<Byte> nCheckedCards=new ArrayList<>(checkedPlayer.getCloseCards());
		List<TingInfo> tingInfos=Hu.checkTing(nCheckedCards, laizies, Hus.HU_NORMAL_WITH_LAIZI,Hus.HU_SHISANYAO);
		checkedPlayer.setTingInfos(tingInfos);
		return !tingInfos.isEmpty();
	
	}
	
	/** 奖马 翻马
	 * return 中了的马牌
	 * */
	public List<Byte> getJiangMaMaCards(BasePlayer player){
		  List<Byte> playerMaCards = ((ShanWeiPlayer)player).getMaCards();
		  List<Byte> maCards = ((ShanWeiGameInfo)gameInfo).getMaCards();
		  List<Byte> result=new ArrayList<>();
		  for (byte card : maCards) {
		   if(playerMaCards.contains(card)){
		    result.add(card);
		   }
		  }
		  return result;
		  
	}
	/**
	 * 中了的正花牌
	 * @param player
	 * @return
	 */
	public List<Byte> getZhengHuaMards(BasePlayer player){
		List<Byte> result=new ArrayList<>();
		ShanWeiPlayer swp=((ShanWeiPlayer)player);
		List<Byte> huaCards = swp.getHuaCards();
		List<Byte> zhengHuaCards = swp.getFlowerCards();
		for (Byte bc : zhengHuaCards) {
			if(huaCards.contains(bc)){
				result.add(bc);
			}
		}
		return result;
	}
	
	/**
	 * 中了的正字牌
	 * @param player
	 * @return
	 */
	public List<Byte> getZhengZiMards(BasePlayer player){
		
		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(player.getCloseCards());
		if (gameInfo.getLastPlayCard()!=0) {
			cards.add(gameInfo.getLastPlayCard());
		}
		
//		List<Byte> zhengZiCards = ImmutableList.of(CARD_DONG,CARD_NAN,CARD_XI,CARD_BEI);
		Set<Byte> zhengZiCards = new HashSet<Byte>();
		
		System.out.println("==================这是最后动作的牌："+gameInfo.getLastPlayCard());
		
		for(Byte card : cards) {
			if (this.countPai(player,card)>=3 && MjHelper.isZiPai(card)) {
				zhengZiCards.add(card);
			}
		}
		
		log.debug("=-=-=-=-=-=-=-=-=正字牌有："+zhengZiCards);
		
		List<Byte> result=new ArrayList<>();
		ShanWeiPlayer swp=((ShanWeiPlayer)player);
		List<Byte> ziCards = swp.getZiCards();
		for (Byte bc : zhengZiCards) {
			if(ziCards.contains(bc)){
				result.add(bc);
			}
		}
		log.debug("-=-=-=-=-=-=玩家"+player.getUserId()+"手中的正字牌有：" + result);
		return result;
	}
	
	
	
	/**
	 * 买马 翻马
	 * 中的马牌
	 * @param player
	 * @return
	 */
	public List<Byte> getMaiMaMaCards(BasePlayer player){
		List<Byte> result=new ArrayList<>();
		ShanWeiPlayer hyp=((ShanWeiPlayer)player);
		List<Byte> maCards = hyp.getMaCards();
		List<Byte> buyMaCards = hyp.getBuyMaCards();
		for (Byte bc : buyMaCards) {
			if(maCards.contains(bc)){
				result.add(bc);
			}
		}
		return result;
	}
	
	// 玩家中的买马牌中，中了几个某个玩家的马牌
	public List<Byte> getMaiMaCards(BasePlayer loser, BasePlayer winner) {
		ShanWeiPlayer shu = (ShanWeiPlayer) loser;
		ShanWeiPlayer ying = (ShanWeiPlayer) winner;
		List<Byte> maCards = ying.getMaCards();// 玩家的马牌
		List<Byte> showMaCards = shu.getBuyMaCards();// 玩家买的马牌
		List<Byte> maiMaCards = new ArrayList<>();// 中的马牌

		for (Byte card : showMaCards) {
			if (maCards.contains(card)) {
				maiMaCards.add(card);
			}
		}
		return maiMaCards;
	}
	
	public List<Byte> getMaiMaCards2(BasePlayer curLoser, BasePlayer elseLoser){
		ShanWeiPlayer swcurLoser = (ShanWeiPlayer)curLoser;
		ShanWeiPlayer swelseLoser = (ShanWeiPlayer)elseLoser;
		
		List<Byte> maCards = swcurLoser.getBuyMaCards();// 当前玩家买的马牌
		List<Byte> showMaCards = swelseLoser.getMaCards();// 其他玩家的马牌
		List<Byte> maiMaCards = new ArrayList<>();
		
//		if (gameInfo.getPlayers().size()==3) {
//			for (int i=0;i<showMaCards.size();i++) {
//				if (maCards.contains(showMaCards.get(i))) {
//					maCards.remove(i);
//				}
//			}
//		}
		maiMaCards = maCards;
		maiMaCards.removeAll(showMaCards);
		
		return maiMaCards;
	}
	
	@Override
	public boolean canPlay(BasePlayer checkedPlayer, byte card) {
		/** 花牌不能打 **/
		boolean canPlay=true;
		if(gameInfo.getFlowerCards().contains(card)) canPlay=false;
		return canPlay;
	}
	
//	@Override
//	public boolean canHu(BasePlayer checkedPlayer, byte actionCard) {
////		log.debug("Start canH playID=" + gameInfo.getPlayId() + ",uid=" + checkedPlayer.getUserId()
//		boolean selfHu=actionCard==CARD_NONE;
////				+ ",actionCard=" + actionCard + ",self=" + selfHu);
//		log.debug("Start canH playID=" + gameInfo.getPlayId() + ",actionCard=" + actionCard + ",self=" + selfHu);
//		
//		ShanWeiGameInfo swg = (ShanWeiGameInfo) gameInfo;
//		ShanWeiPlayer swPlayer = (ShanWeiPlayer)checkedPlayer;
//		
// 		List<String> wanfa = gameInfo.getWanfa();
//		
//		List<Byte> checkCards=new ArrayList<Byte>(checkedPlayer.getCloseCards());
//		
//		if(!selfHu){
//			checkCards.add(actionCard);
//		}
//		//是否可以胡
//		boolean rtn = false;
//		//胡牌番型
////		Fan fan = null;
//		
//		if (MjHelper.isQiHua(swPlayer)) {
//			rtn = true;
//		}
//		
//		
//		ComplexHu hu=ComplexHu.from(checkCards).addHuStrategy(Hus.normalHuStrategy());
//		hu.needCheckHu().startCheck();
//		
//		if(hu.canHu()){
//			int base=gameInfo.getBase();
//			List<Pattern> patterns = hu.getPatterns();
//			
//			swPlayer.getFans().add(FAN_TDH);
////			for (Pattern pt :hu.getPatterns()) {
////			}
//			
//			if(swg.isInLoopGang()) swPlayer.getFans().add(FAN_QGH);
//			
//			//海底捞翻倍     MinRemainCount是牌局的最后一张牌
//			if(gameInfo.getCards().size()==getMinRemainCount()&&gameInfo.getWanfa().contains(ShanWeiWanFa.WF_HAIDILAOYUE_2FAN)){
//				swPlayer.setHdlfb(true);
//				swPlayer.getFans().add(FAN_HDLY);
//			}
//			//杠上开花两番
//			if(gameInfo.getWanfa().contains(ShanWeiWanFa.WF_GANGFLOWER_2FAN)) {
//				swPlayer.setGf2fan(true);
//				swPlayer.getFans().add(FAN_GSKH);
//			}
//			//清一色自摸加两番
//			if(gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QYS_ZM_2FAN)) {
//				if (selfHu && Fans.清一色.fit(swPlayer.getCloseCards(), swPlayer.getOpenCards())) {
//					swPlayer.getFans().add(FAN_QYSZMHU);
//				}
//			}
//			if (MjHelper.isduiduiHu(swPlayer, patterns)) {
//				swPlayer.getFans().add(new Fan("对对胡", 5));
//			}
//			if (MjHelper.ishunyise(swPlayer, checkCards)) {
//				swPlayer.getFans().add(new Fan("混一色", 5));
//			}
//			if (MjHelper.isqingyise(swPlayer, checkCards)) {
//				swPlayer.getFans().add(new Fan("清一色", 10));
//			}
//			if (MjHelper.isQiHua(swPlayer)) {
//				swPlayer.getFans().add(new Fan("七花", 14));
////				if (wanfa.contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA)) {
////					fan = new Fan("16番2无马", 16);
////				}
//			}
//			if (MjHelper.isXiaoSanYuan(patterns)) {
//				swPlayer.getFans().add(new Fan("小三元", 20));
//			}
//			if (MjHelper.isXiaoSiXi(patterns)) {
//				swPlayer.getFans().add(new Fan("小四喜", 20));
//			}
//			if (MjHelper.isDaSanYuan(patterns)) {
//				swPlayer.getFans().add(new Fan("大三元", 40));
//			}
//			if (MjHelper.isDaSiXi(patterns)) {
//				swPlayer.getFans().add(new Fan("大三元", 40));
//			}
//			if (MjHelper.isquanzi(swPlayer, checkCards)) {
//				swPlayer.getFans().add(new Fan("全子", 40));
//			}
////			if (Hus.HU_SHISANYAO.checkHu(checkCards, 0) != null) {
////				swPlayer.getFans().add(new Fan("十三幺", 40));
////			}
//			if (swPlayer.equals(gameInfo.getBanker())&&swPlayer.isTianHu()) {
//				swPlayer.getFans().add(new Fan("天胡", 40));
//			}
//			if (!swPlayer.equals(gameInfo.getBanker())&&swPlayer.isTianHu()) {
//				swPlayer.getFans().add(new Fan("地胡", 40));
//			}
//			
//			//获得番型
//			List<Fan> fans = swPlayer.getFans();
//			if( fans.isEmpty()){
//				return false;
//			}
//			
//			//天地胡的番型
//			boolean tdh=false;
//			for (Fan fan : fans) {
//				if(fan.getFanName().equals("天胡")||fan.getFanName().equals("地胡")){
//					tdh=true;break;
//				}
//			}
//			
//			//如果玩法没有选择番型叠加 或者是带天地胡的话  即使胡的是多种牌型叠加 结算时牌型也不叠加 取胡的牌型最大的那种牌型番型  
//			if(tdh){
//				TreeMap<Integer,Fan> map=new TreeMap<>();
//				for (Fan fan : fans) {
//					map.put(fan.getFan(), fan);
//				}
//				Entry<Integer, Fan> entry=map.lastEntry();
//				swPlayer.getFans().clear();
//				swPlayer.getFans().add(entry.getValue());
//			}
//			
//			rtn = hu.canHu();
//		}
//		
//		
////		if(rtn){
////			checkedPlayer.getFans().clear();
////			checkedPlayer.getFans().add(fan);
////		}
//		return rtn;
//	}
	
	
	@Override
	public boolean canHu(BasePlayer checkedPlayer, byte actionCard) {
		boolean selfHu=actionCard==CARD_NONE;
		log.debug("Start canH playID=" + gameInfo.getPlayId() + ",uid=" + checkedPlayer.getUserId()
				+ ",actionCard=" + actionCard + ",self=" + selfHu);
		ShanWeiGameInfo swg = (ShanWeiGameInfo) gameInfo;
		ShanWeiPlayer swPlayer = (ShanWeiPlayer)checkedPlayer;
		swPlayer.getFans().clear();//每次查胡，先清空番型
		List<Fan> fans = new ArrayList<>();
		
//		if(hzg.isInLoopGang() && !hzg.getWanfa().contains(WF_QIANGGANG_BSJ)) return false;
//		//如果只是判断手里有红中则不能抢杠胡，则再这里判断，下面删除
//		if(hzg.isInLoopGang() && checkedPlayer.getCloseCards().contains(hzg.getLaizi())) return false;
//		if(swg.isInLoopGang()) return false;
		List<Byte> cards=new ArrayList<Byte>(checkedPlayer.getCloseCards());
		//不能胡癞子
		if(!selfHu){
//			if(isLaiZi(actionCard)){
//				return false;
//			}
			cards.add(actionCard);
		}
		//是否可以胡
		boolean rtn = false;
		boolean huqihua = false;
//		if (MjHelper.isQiHua(checkedPlayer)) {
//			rtn = true;
//		}
		
		if (checkedPlayer.getFlowerCards().size()>=7 && swPlayer.isCanqihuahu()) {
			rtn = true;
			huqihua = true;
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA)) {
				fans.add(new Fan("七花", 10));
			}
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA)) {
				fans.add(new Fan("七花", 16));
			}else if(gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_14)) {
				fans.add(new Fan("七花", 14));
			}
		}
		
		//胡牌番型
//		Fan fan = null;
//		List<Byte> laizies=new ArrayList<>();
//		laizies.add(gameInfo.getLaizi());
		ComplexHu hu=ComplexHu.from(cards)
//				  .setLaiZi(laizies)
				  .addHuStrategy(Hus.normalHuStrategy());
//		if(gameInfo.getWanfa().contains(WF_KEHU_QXD)) hu.addHuStrategy(Hus.qixiaoduiStrategy());
		hu.needCheckHu().startCheck();
		List<Pattern> patterns = hu.getPatterns();
		
		boolean canHu = hu.canHu();
		Map<HuStrategy, List<List<Byte>>> checkHu = Hu.checkHu(cards, Lists.emptyList(), Hus.HU_SHISANYAO);
		if (!canHu) {
			canHu = !checkHu.isEmpty();
		}
		
		if(canHu){
			
			//TODO 如果是：抢杠胡，并且玩家手里有有癞子， 
//			if(gameInfo.isGang() && cards.contains(gameInfo.getLaizi())){
//				//则校验是否用癞子来抢杠，如是，则不能抢杠胡牌
//				if(!checkHuByLZ(hu.getPatterns(), gameInfo.getLaizi(), actionCard)){
//					return false;
//				}
//			}
//			for (Pattern pt :hu.getPatterns()) {
//				if(Hus.qixiaoduiStrategy().name().equals(pt.getHuStrategy().name())){
//					fan = FAN_QXD;
//					break;
//				}else{
//					fan = FAN_TDH;
//				}
//			}
			
			//胡牌成牌型
			swPlayer.setMakePaiXing(true);
			
//			swPlayer.getFans().add(FAN_TDH);
			if (checkHu.isEmpty()) {
//				fans.add(FAN_TDH);
			}
		
			//清一色自摸加两番
			if(gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QYS_ZM_2FAN)) {
//				if (Fans.清一色.fit(swPlayer.getCloseCards(), swPlayer.getOpenCards()) && selfHu) {
//					fans.add(FAN_QYSZMHU);
//				}
				if (MjHelper.isqingyise(swPlayer, cards) && selfHu) {
					fans.add(FAN_QYSZMHU);
				}
			}
			//海底捞月    MinRemainCount是牌局的最后一张牌
			if(gameInfo.getCards().size()==getMinRemainCount()&&gameInfo.getWanfa().contains(ShanWeiWanFa.WF_HAIDILAOYUE_2FAN)){
				swPlayer.setHdljia2(true);
				fans.add(FAN_HDLY);
			}
			//杠上开花两番
			if(gameInfo.getWanfa().contains(ShanWeiWanFa.WF_GANGFLOWER_2FAN)&&gameInfo.isGang()) {
				swPlayer.setGf2fan(true);
				fans.add(FAN_GSKH);
			}
			if (MjHelper.isduiduiHu(swPlayer, patterns)) {
				fans.add(new Fan("对对胡", 5));
			}
			if (MjHelper.ishunyise(swPlayer, cards)) {
				fans.add(new Fan("混一色", 5));
			}
			if (MjHelper.isqingyise(swPlayer, cards)) {
				fans.add(new Fan("清一色", 10));
			}
			
//			if (this.calcZi(swPlayer)>0) {
//				fans.add(new Fan("字", calcZi(swPlayer)));
//			}
//			if (this.calcFlower(swPlayer)>0) {
//				fans.add(new Fan("花", calcFlower(swPlayer)));
//			}
			
//			if (MjHelper.isQiHua(swPlayer)) {
//			if (swPlayer.getFlowerCards().size()==7) {
//				swPlayer.getFans().add(new Fan("七花", 14));
////				if (wanfa.contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA)) {
////					fan = new Fan("16番2无马", 16);
////				}
//			}
//			if (MjHelper.isXiaoSanYuan(patterns)) {
//				fans.add(new Fan("小三元", 20));
//			}
//			if (MjHelper.isXiaoSiXi(patterns)) {
//				fans.add(new Fan("小四喜", 20));
//			}
//			if (MjHelper.isDaSanYuan(patterns)) {
//				fans.add(new Fan("大三元", 40));
//			}
//			if (MjHelper.isDaSiXi(patterns)) {
//				fans.add(new Fan("大四喜", 40));
//			}
//			if (MjHelper.isquanzi(swPlayer, cards)) {
//				fans.add(new Fan("全字", 40));
//			}
			
			if (MjHelper.isDaXiao3Yuan(swPlayer,cards)==2) {
				fans.add(new Fan("小三元", 20));
			}
			if (MjHelper.isDaXiao3Yuan(swPlayer,cards)==1) {
				fans.add(new Fan("大三元", 40));
			}
			if (MjHelper.isDaXiao4Xi(swPlayer,cards)==2) { 
				fans.add(new Fan("小四喜", 20));
			}
			if (MjHelper.isDaXiao4Xi(swPlayer,cards)==1) {
				fans.add(new Fan("大四喜", 40));
			}
			if (MjHelper.isquanzi(swPlayer, cards)) {
				fans.add(new Fan("全字", 40));
			}
			
//			if (Hus.HU_SHISANYAO.checkHu(cards, 0) != null) {
//				swPlayer.getFans().add(new Fan("十三幺", 40));
//			}
			
			
			//十三幺可抢杠胡
			if (!checkHu.isEmpty()) {
				BaseFlowGameInfo gameInfof = (BaseFlowGameInfo)gameInfo;
				if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_SHISANYAO_QGH) && gameInfof.isInLoopGang()) {
					return false;
				}
				fans.add (new Fan("十三幺", 40));
			}
//			 当七花胡牌的时候，牌型判断为天胡
			
			if (swPlayer.equals(gameInfo.getBanker()) && swPlayer.isCanTianHu()) {
				fans.add(new Fan("天胡", 40));
			}
			boolean canDianPaoDiHu=((ShanWeiGameInfo)gameInfo).isCanHuDianPaoDiHu();//牌局能否胡点炮地胡
			boolean canHuDiHu=((ShanWeiGameInfo)gameInfo).isCanHuDiHu();//增加一个条件，能胡地胡？
//			if (!swPlayer.equals(gameInfo.getBanker()) && swPlayer.isCanTianHu()&&canHuDiHu) {
			if (!swPlayer.equals(gameInfo.getBanker()) && swPlayer.isCandihu()&&canHuDiHu) {
				if (canDianPaoDiHu) {//能胡点炮地胡，说明牌局 刚是庄出牌，且没有碰杠发生
					fans.add(new Fan("地胡", 40));
				}else {//不能胡点炮地胡，需要判断是不是闲摸第一张牌
					if (selfHu) {
						fans.add(new Fan("地胡", 40));
					}
				}
				
			}
			
			
			//自摸和天胡，地胡，七花胡 不叠加
			if (selfHu && !swPlayer.isCanTianHu() && !huqihua) {
				fans.add(FAN_ZM);
			}
			
			if(((BaseFlowGameInfo)gameInfo).isInLoopGang()) {
				fans.add(FAN_QGH);
			}
			
			
			
			/*if (huqihua) {
				//获得番型
				//List<Fan> fans = swPlayer.getFans();
				TreeMap<Integer,Fan> treeMap=new TreeMap<>();
				int f=0;
				for (Fan fan : fans) {
					treeMap.put(fan.getFan(), fan);
					f+=fan.getFan();
					if (fan.getFanName().equals("七花")) {
						qihuaFan = fan.getFan();
					}
				}
				if (treeMap.size() > 0) {
					Entry<Integer, Fan> entry=treeMap.lastEntry();
					if (entry.getValue().getFan()>qihuaFan) {
						Iterator<Fan> it = fans.iterator();
						while(it.hasNext()){
							Fan fan = it.next();
							if(fan.getFanName().equals("七花")){
								it.remove();
							}
						}
					}else {
						fans.clear();
						fans.add(new Fan("七花", qihuaFan));
					}
				}
				
			}*/
			
			//如果没有选择不设封顶，则取番型最大
			if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_NOFENGDIN)) {
				//获得番型
				//List<Fan> fans = swPlayer.getFans();
				TreeMap<Integer,Fan> map=new TreeMap<>();
				int f=0;
				for (Fan fan : fans) {
					map.put(fan.getFan(), fan);
					f+=fan.getFan();
				}
				if (f>=40) {
					Entry<Integer, Fan> entry=map.lastEntry();
					swPlayer.getFans().clear();
					swPlayer.getFans().add(entry.getValue());
				}
			}
			rtn = true;
		}
		/*else {
			//正常胡不出来就查十三幺胡    十三幺的话也可以判断是不是天地胡  
			Map<HuStrategy, List<List<Byte>>> hu2 = Hu.checkHu(cards, Lists.emptyList(), Hus.HU_SHISANYAO);
			if(hu2.isEmpty()){
				return false;
			}
			fans.add(new Fan("十三幺", 40));
			if (swPlayer.equals(gameInfo.getBanker()) && swPlayer.isTianHu()) {
				fans.add(new Fan("天胡", 40));
			}
			if (!swPlayer.equals(gameInfo.getBanker()) && swPlayer.isTianHu()) {
				fans.add(new Fan("地胡", 40));
			}
			return !hu2.isEmpty();
		}*/
		
		int qihuaFan =0;
		// 得到七花的番
		for (Fan fan : fans) {
			if (fan.getFanName().equals("七花")) {
				qihuaFan = fan.getFan();
			}
		}
		
		if (huqihua) {
			//胡七花，不成牌型
			if (!canHu) {
				fans.clear();
				fans.add(new Fan("七花", qihuaFan));
			}else {//胡七花，成牌型
//				TreeMap<Integer,Fan> treeMap=new TreeMap<>();
				
				int f=0;
//				for (Fan fan : fans) {
//					//treeMap.put(fan.getFan(), fan);
//					if (fan.getFanName().equals("七花")) {
//						fans.remove(fan);
//					}
//					f+=fan.getFan();
//				}
				//胡七花成牌型，加上自摸番
				if (!swPlayer.isCanTianHu()) {
					fans.add(FAN_ZM);
				}
				Iterator<Fan> it = fans.iterator();
				while(it.hasNext()){
					Fan fan = it.next();
					if(fan.getFanName().equals("七花")){
						it.remove();
					}
				}
				
//				while(it.hasNext()){
//					Fan fan = it.next();
//					f+=fan.getFan();
//				}
				
				for (Fan fan : fans) {
					f+=fan.getFan();
				}
				
				// 七花的番比普通牌型番与玩家花的番值和要大
				if (qihuaFan>=(f+calcFlower(swPlayer))) {
					fans.clear();
					fans.add(new Fan("七花", qihuaFan));
				}else {// 七花的番比普通牌型番与玩家花的番值和要小
//					fans.addAll(fans);
				}
			}
		}
		
		if(rtn){
			swPlayer.getFans().clear();
			if (swPlayer.getFans()!=null) {
				for(Fan fan:fans) {
					swPlayer.getFans().add(fan);
				}
				if (swPlayer.getFans().isEmpty()) {//无牌型，则加入鸡胡
					swPlayer.getFans().add(FAN_TDH);	
				}else  {//只有自摸，抢杠胡，杠开时，海底捞月，也需要加入 鸡胡
					int fanSize=swPlayer.getFans().size();
					boolean isJiHu=true;
					if (fanSize==2||fanSize==1) {
						for (int i = 0; i < fanSize; i++) {
							String fanName=swPlayer.getFans().get(i).getFanName();
							if (fanName!=FAN_QGH.getFanName()&&fanName!=FAN_GSKH.getFanName()
									&&fanName!=FAN_ZM.getFanName()&&fanName!=FAN_HDLY.getFanName()) {
								isJiHu=false;
								break;
							}
						}
						if (isJiHu) {
							swPlayer.getFans().add(FAN_TDH);	
						}
					}
				}
			}
		}
		return rtn;
	}
	
//	@Override
//	public boolean canHu(BasePlayer checkedPlayer, byte actionCard) {
//		boolean selfHu=actionCard==CARD_NONE;
//		log.debug("Start canH playID=" + gameInfo.getPlayId() + ",uid=" + checkedPlayer.getUserId()
//		+ ",actionCard=" + actionCard + ",self=" + selfHu);
//		ShanWeiGameInfo swg = (ShanWeiGameInfo) gameInfo;
//		ShanWeiPlayer swPlayer = (ShanWeiPlayer)checkedPlayer;
////		if(hzg.isInLoopGang() && !hzg.getWanfa().contains(WF_QIANGGANG_BSJ)) return false;
////		//如果只是判断手里有红中则不能抢杠胡，则再这里判断，下面删除
////		if(hzg.isInLoopGang() && checkedPlayer.getCloseCards().contains(hzg.getLaizi())) return false;
////		if(swg.isInLoopGang()) return false;
//		List<Byte> cards=new ArrayList<Byte>(checkedPlayer.getCloseCards());
//		//不能胡癞子
//		if(!selfHu){
////			if(isLaiZi(actionCard)){
////				return false;
////			}
//			cards.add(actionCard);
//		}
//		//是否可以胡
//		boolean rtn = false;
////		if (MjHelper.isQiHua(checkedPlayer)) {
////			rtn = true;
////		}
//		
//		if (checkedPlayer.getFlowerCards().size()==7) {
//			rtn = true;
//		}
//		
//		//胡牌番型
//		Fan fan = null;
//		List<Byte> laizies=new ArrayList<>();
//		laizies.add(gameInfo.getLaizi());
//		ComplexHu hu=ComplexHu.from(cards)
////				  .setLaiZi(laizies)
//				.addHuStrategy(Hus.normalHuStrategy());
////		if(gameInfo.getWanfa().contains(WF_KEHU_QXD)) hu.addHuStrategy(Hus.qixiaoduiStrategy());
//		hu.needCheckHu().startCheck();
//		if(hu.canHu()){
//			//TODO 如果是：抢杠胡，并且玩家手里有有癞子， 
////			if(gameInfo.isGang() && cards.contains(gameInfo.getLaizi())){
////				//则校验是否用癞子来抢杠，如是，则不能抢杠胡牌
////				if(!checkHuByLZ(hu.getPatterns(), gameInfo.getLaizi(), actionCard)){
////					return false;
////				}
////			}
////			for (Pattern pt :hu.getPatterns()) {
////				if(Hus.qixiaoduiStrategy().name().equals(pt.getHuStrategy().name())){
////					fan = FAN_QXD;
////					break;
////				}else{
////					fan = FAN_TDH;
////				}
////			}
//			
////			swPlayer.getFans().add(FAN_TDH);
//			fan = FAN_TDH;
//			if(swg.isInLoopGang()) {
//				/*swPlayer.getFans().add(FAN_QGH);*/
//				fan = FAN_QGH;
//			}
//			rtn = true;
//		}
//		if(rtn){
//			checkedPlayer.getFans().clear();
//			if (swPlayer.getFans()!=null) {
//				checkedPlayer.getFans().add(fan);
//			}
//		}
//		return rtn;
//	}
	
	
	/*
	 * 汕尾麻将支持一炮多响
	 * (non-Javadoc)
	 * @see com.dszy.game.gamelogic.majong.logic.BaseLogic#isSuportMutiHu()
	 */
	@Override
	public boolean isSuportMutiHu() {
		return true;
	}
	
	/*
	 * 无赖子
	 */
	@Override
	public boolean isLaiZi(byte card) {
		return false;
	}
	
	@Override
	public void initGameInfo(Desk desk) {
		
	}
	
	private void calcMaGengGang(BasePlayer winner, List<BasePlayer> losers) {

		List<OpenCard> openCards = winner.getOpenCards();
		int clearG=0,addG=0,anG=0, addGNone=0;
		int base = gameInfo.getBase();
		//base=gameInfo.getBase();
		for (OpenCard openCard : openCards) {
			byte type = openCard.getOpenCardsType();
			//明杠的补杠
			if(type==CARDTYPE_ADDGANG){
				addG++;
				//勾选马跟杠
				if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MAGENGANG)) {
					int total = 0;
					total = 4*base*jiangMaCount(winner);
					for (BasePlayer loser : losers) {	
						winner.setScore(winner.getScore() + total);
						loser.setScore(loser.getScore() - total);
						winner.setScoreDiff(winner.getScoreDiff() + total);
						loser.setScoreDiff(loser.getScoreDiff() - total);
					}
					
					log.debug("-=-=-=-=-=-=-=马跟杠的钱有"+total);
				}
				
				if(!((ShanWeiPlayer)winner).getNoFeeGangCards().contains(openCard.getOpenCardsOrig())){
					//只有是正常补杠的才给钱
				}
			}
			
			if (type==CARDTYPE_YANGMA) {//先碰后杠不计分，算养马
				log.debug("先碰后杠不计分，算养马");
				addGNone++;
			}
			
			//明杠的直杠
			if(type==CARDTYPE_CLEARGANG){
				clearG++;
				//勾选马跟杠
				if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MAGENGANG)) {
					int total = 0;
					total = 4*base*jiangMaCount(winner);
					for (BasePlayer loser : losers) {
						if(loser.getUserId()==openCard.getOpenCardsUserID()){
							winner.setScore(winner.getScore() + total);
							loser.setScore(loser.getScore() - total);
							winner.setScoreDiff(winner.getScoreDiff() + total);
							loser.setScoreDiff(loser.getScoreDiff() - total);
						}
					}
					
					log.debug("-=-=-=-=-=-=-=马跟杠的钱有"+total);
				}
				
			}
			//暗杠
			if(type==CARDTYPE_ANGANG){
				anG++;
				//勾选马跟杠
				if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MAGENGANG)) {
					int total = 0;
					total = 4*base*jiangMaCount(winner);
					for (BasePlayer loser : losers) {	
						winner.setScore(winner.getScore() + total);
						loser.setScore(loser.getScore() - total);
						winner.setScoreDiff(winner.getScoreDiff() + total);
						loser.setScoreDiff(loser.getScoreDiff() - total);
					}
					
					log.debug("-=-=-=-=-=-=-=马跟杠的钱有"+total);
				}
				
			}
		}   

	}
	
	/**
	 * 结算杠 明杠，暗杠，补杠
	 * @param winner
	 * @param losers
	 */
	private void calcG(BasePlayer winner, List<BasePlayer> losers) {

		List<OpenCard> openCards = winner.getOpenCards();
		int clearG=0,addG=0,anG=0, addGNone=0;
		int base = gameInfo.getBase();
		//base=gameInfo.getBase();
		for (OpenCard openCard : openCards) {
			byte type = openCard.getOpenCardsType();
			//明杠的补杠
			if(type==CARDTYPE_ADDGANG){
				addG++;
				for (BasePlayer loser : losers) {
					int total = 4*base;
					winner.setScore(winner.getScore() + total);
					loser.setScore(loser.getScore() - total);
					winner.setScoreDiff(winner.getScoreDiff() + total);
					loser.setScoreDiff(loser.getScoreDiff() - total);
				}
				
				
				if(!((ShanWeiPlayer)winner).getNoFeeGangCards().contains(openCard.getOpenCardsOrig())){
					//只有是正常补杠的才给钱
				}
			}
			
			if (type==CARDTYPE_YANGMA) {//先碰后杠不计分，算养马
				log.debug("先碰后杠不计分，算养马");
				addGNone++;
			}
			
			//明杠的直杠
			if(type==CARDTYPE_CLEARGANG){
				clearG++;
				for (BasePlayer loser : losers) {
					int total = 4*base;
					if(loser.getUserId()==openCard.getOpenCardsUserID()){
						winner.setScore(winner.getScore() + total);
						loser.setScore(loser.getScore() - total);
						winner.setScoreDiff(winner.getScoreDiff() + total);
						loser.setScoreDiff(loser.getScoreDiff() - total);
					}
				}
				
			}
			//暗杠
			if(type==CARDTYPE_ANGANG){
				anG++;
				for (BasePlayer loser : losers) {
					int total = 4*base;
					winner.setScore(winner.getScore() + total);
					loser.setScore(loser.getScore() - total);
					winner.setScoreDiff(winner.getScoreDiff() + total);
					loser.setScoreDiff(loser.getScoreDiff() - total);
				}
			}
			//养马
		}   
	    //传给前端 
		if(clearG>0){
			winner.getFans().add(new Fan("直杠",2*clearG));
		}
		if(addG>0){
			winner.getFans().add(new Fan("补杠",2*addG));
			
		}
		if (addGNone > 0) {
//			winner.getFans().add(new Fan("养马", 2*addGNone));
		}
		if(anG>0){
			winner.getFans().add(new Fan("暗杠",2*anG));
		}
		
		log.debug("=============杠牌分有："+(clearG+addG+anG)*4*base);
		
//		//勾选马跟杠
//		if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MAGENGANG)) {
//			int total = 0;
//			total = 2*base*(addG+clearG+anG)*jiangMaCount(winner);
//			for (BasePlayer loser : losers) {	
//				winner.setScore(winner.getScore() + total);
//				loser.setScore(loser.getScore() - total);
//				winner.setScoreDiff(winner.getScoreDiff() + total);
//				loser.setScoreDiff(loser.getScoreDiff() - total);
//			}
//			
//			log.debug("-=-=-=-=-=-=-=马跟杠的钱有"+total);
//		}
		
		
	}
	
	public void calcGang(List<BasePlayer> players) {
		for (BasePlayer basePlayer : players) {
			List<BasePlayer> tmps = new ArrayList<>(players);
			tmps.remove(basePlayer);
			this.calcG(basePlayer, tmps);
		}
	}
	
	public int calcGangFlower(BasePlayer player) {
		int gangFlower=0;
		if (gameInfo.isGang()) {
			for(OpenCard openCard:player.getOpenCards()){
				if(openCard.getOpenCardsType()==CARDTYPE_CLEARGANG){
					gangFlower++;
				}
				if(openCard.getOpenCardsType()==CARDTYPE_ADDGANG){
					gangFlower++;
				}
				if(openCard.getOpenCardsType()==CARDTYPE_ANGANG){
					gangFlower++;
				}
			}
		}
		return gangFlower;
	}
	
	
	/**
	 * 结算番型的    番型叠加 倍数的
	 * @param winner
	 * @param loser
	 * @param baopaier 要判断是否包三家的问题
	 */
//	private void calc(ShanWeiPlayer winner, ShanWeiPlayer loser,
//			BasePlayer baopaier) {
//		boolean hdlfb = winner.isHdlfb();
//		boolean baopai=baopaier!=null;
//		int baseCash=0;//番的总数
//		List<Fan> fans = winner.getFans();
//		for (Fan fan : fans) {
//			baseCash+=fan.getFan();
//		}
////		boolean hasLaizi=false;
//		//List<Byte> myCards = winner.getMyCards();
////		for (byte mc : winner.getCloseCards()) {
////			if(isLaiZi(mc)){
////				hasLaizi=true;break;
////			}
////		}
//		//番*底 如果番为0 则为底数
//		baseCash = baseCash==0?((ShanWeiGameInfo)gameInfo).getBase() :baseCash;
//		int total=hdlfb?baseCash*2:baseCash;
//		//log.debug("本局玩法:  "+gameInfo.getWanfa()+" 是否有赖子: "+hasLaizi+" 是否鸡胡： "+gameInfo.getWanfa().contains(WANFA_HU_DAIJIHU));
////		if(){
////			total=1*total;
////		}
//		if(baopai){
//			winner.setScore(winner.getScore()+total);
//			baopaier.setScore(baopaier.getScore()-total);
//			winner.setScoreDiff(winner.getScoreDiff()+total);
//			baopaier.setScoreDiff(baopaier.getScoreDiff()-total);
//		}else{
//			winner.setScore(winner.getScore()+total);
//			loser.setScore(loser.getScore()-total);
//			winner.setScoreDiff(winner.getScoreDiff()+total);
//			loser.setScoreDiff(loser.getScoreDiff()-total);
//		}	
//	}

	
	
	@Override
	public void settle() {

		//1. 结算类型 1流局 2自摸 算番型 3点炮
		int winType = gameInfo.getWintype();
		System.out.println("奖马玩法中，系统马牌："+((ShanWeiGameInfo)gameInfo).getMaCards());
		for (BasePlayer bp : gameInfo.getPlayers()) {
			ShanWeiPlayer swp=(ShanWeiPlayer) bp;
			System.out.println("玩家："+swp);
			System.out.println("玩家马牌："+swp.getMaCards());
			System.out.println("买马玩法中 玩家买的马："+swp.getBuyMaCards());
		}
		
			
//			//如果没有选择不设封顶，则取番型最大
//			if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_NOFENGDIN)) {
//				//获得番型
//				List<Fan> fans = swPlayer.getFans();
//				TreeMap<Integer,Fan> map=new TreeMap<>();
//				int f=0;
//				for (Fan fan : fans) {
//					map.put(fan.getFan(), fan);
//					f+=fan.getFan();
//				}
//				if (f>=40) {
//					Entry<Integer, Fan> entry=map.lastEntry();
//					swPlayer.getFans().clear();
//					swPlayer.getFans().add(entry.getValue());
//				}
//			}
//		}
		
		
		if(winType==WINTYPE_SELF_HU){
			log.debug("自摸胡牌");
			ShanWeiPlayer winner=(ShanWeiPlayer) gameInfo.getWinners().get(0);
			List<BasePlayer> losers=new ArrayList<>(gameInfo.getPlayers());
			losers.remove(winner);
			
			List<Fan> fans = winner.getFans();
			int f=0;
			for (Fan fan : fans) {
				f+=fan.getFan();
			}
			//f+=2;
//			BasePlayer baopaier=null;
//			statistics(gameInfo.getWinners(), losers);
			statistics(gameInfo.getWinners(), losers, null);
			
			for(BasePlayer loser:losers){
				calc(winner, (ShanWeiPlayer) loser);
			}
			
			//买马马钱
			calMaiMa(winner, losers);
			//奖马马钱
			calJiangMa(winner, losers);
			
			//3.算杠钱
			List<BasePlayer> players = gameInfo.getPlayers();
			for (BasePlayer basePlayer : players) {
				List<BasePlayer> tmps=new ArrayList<>(players);
				tmps.remove(basePlayer);
				calcG(basePlayer,tmps);
//				calcMaGengGang(basePlayer, Lists.newArrayList(loser));
				//个人结算记录暗杠 补杠 直杠的次数的
				ShanWeiPlayer swp = (ShanWeiPlayer)basePlayer;
				swp.setZhigangcount(swp.getZhigangcount()+swp.getClearGangCount());
				swp.setAnagangcount(swp.getAnagangcount()+swp.getAnGangCount());
				swp.setBugangcount(swp.getBugangcount()+swp.getAddGangCount());
			}
			//算马跟杠
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MAGENGANG)) {
				calcMaGengGang(winner, losers);
			}
			
			long scoreDiff = winner.getScoreDiff();
			int paiXingScore = calcPaiXing(winner);
			
			log.debug("------------------>>赢家得分差"+scoreDiff);
			log.debug("------------------>>牌型分"+paiXingScore);
			
			int totalMax = gameInfo.getBase()*40*2;
			
//			if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_NOFENGDIN) && paiXingScore>totalMax) {
//				for (BasePlayer loser:losers) {
//					winner.setScoreDiff(0);
//					loser.setScoreDiff(0);
//				}
//				
//				for (BasePlayer loser:losers) {
//					winner.setScore(winner.getScore()+totalMax);
//					loser.setScore(loser.getScore()-totalMax);
//					winner.setScoreDiff(winner.getScoreDiff()+totalMax);
//					loser.setScoreDiff(loser.getScoreDiff()-totalMax);
//				}
//			}
			if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_NOFENGDIN) && paiXingScore>totalMax) {
				for (BasePlayer loser:losers) {
					winner.setScore(winner.getScore()-paiXingScore+totalMax);
					loser.setScore(loser.getScore()+paiXingScore-totalMax);
					winner.setScoreDiff(winner.getScoreDiff()-paiXingScore+totalMax);
					loser.setScoreDiff(loser.getScoreDiff()+paiXingScore-totalMax);
				}
			}
			
			
		}
		
		if (winType==WINTYPE_HU || winType==WINTYPE_LOOP_GANG) {
			log.debug(" settle(), winType= 点炮单人胡");
//			info(log, ()->" settle(), base= "+ baseScore+ ", gangBase= "+ suGameInfo.getGangBase());
			List<BasePlayer> winners=gameInfo.getWinners();
			BasePlayer loser=gameInfo.getLastPlayer();
			statistics(winners, Lists.newArrayList(loser),((ShanWeiPlayer) gameInfo.getLastPlayer()));
			int base = gameInfo.getBase();
			for (BasePlayer winner : winners) {
				calJiangMa(winner, Lists.newArrayList(loser));
			}
			int totalMax = gameInfo.getBase()*40*2;
			//一炮一响
			if (winners.size()==1) {
				
				calMaiMa(winners, loser);
				for(BasePlayer wi :winners) {
					calc(wi, loser);
					log.debug(wi+"====番的信息==="+wi.getFans());
					log.debug(loser+"====番的信息==="+loser.getFans());
				}
				
				for(BasePlayer win:gameInfo.getWinners()){
					int winScore = calcPaiXing(win);
					//普通点炮
					if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_NOFENGDIN) && winScore>totalMax && !gameInfo.isLoopGang()) {
						win.setScore(win.getScore()-winScore+totalMax);
						loser.setScore(loser.getScore()+winScore-totalMax);
						win.setScoreDiff(win.getScoreDiff()-winScore+totalMax);
						loser.setScoreDiff(loser.getScoreDiff()+winScore-totalMax);
					}
					//单家抢杠胡
					if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_NOFENGDIN) && winScore>totalMax && gameInfo.isLoopGang()) {
						win.setScore(win.getScore()-winScore*3+totalMax*3);
						loser.setScore(loser.getScore()+winScore*3-totalMax*3);
						win.setScoreDiff(win.getScoreDiff()-winScore*3+totalMax*3);
						loser.setScoreDiff(loser.getScoreDiff()+winScore*3-totalMax*3);
					}
				}
			
			}else {
				log.debug("+++++++++++++//一炮多响不买马");
				for(BasePlayer wi :winners) {
					calcAll(wi, loser);
					//calJiangMa(wi, Lists.newArrayList(loser));
					//calMaiMa(wi, Lists.newArrayList(loser));
				}
				
				for(BasePlayer win:gameInfo.getWinners()){
					int winScore = calcPaiXing(win);
					if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_NOFENGDIN) && winScore>totalMax) {
	
						win.setScore(win.getScore()-winScore*3+totalMax*3);
						loser.setScore(loser.getScore()+winScore*3-totalMax*3);
						win.setScoreDiff(win.getScoreDiff()-winScore*3+totalMax*3);
						loser.setScoreDiff(loser.getScoreDiff()+winScore*3-totalMax*3);
					}
				}
			}
			
			//3.算杠钱
			List<BasePlayer> players = gameInfo.getPlayers();
			for (BasePlayer basePlayer : players) {
				List<BasePlayer> tmps=new ArrayList<>(players);
				tmps.remove(basePlayer);
				calcG(basePlayer,tmps);
//				calcMaGengGang(basePlayer, tmps);
				//个人结算记录暗杠 补杠 直杠的次数的
				ShanWeiPlayer swp = (ShanWeiPlayer)basePlayer;
				swp.setZhigangcount(swp.getZhigangcount()+swp.getClearGangCount());
				swp.setAnagangcount(swp.getAnagangcount()+swp.getAnGangCount());
				swp.setBugangcount(swp.getBugangcount()+swp.getAddGangCount());
			}
			//算马跟杠
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MAGENGANG)) {
				int gangCount = 0;
				gangCount = gameInfo.getWinners().get(0).getAnGangCount()+gameInfo.getWinners().get(0).getAddGangCount()+gameInfo.getWinners().get(0).getClearGangCount();
				if (gangCount>0) {
					for (BasePlayer basePlayer : winners) {
						List<BasePlayer> tmps=new ArrayList<>(players);
						tmps.remove(basePlayer);
						calcMaGengGang(basePlayer, tmps);
					}
				}else {
					calcMaGengGang(winners.get(0),Lists.newArrayList(loser));
				}
			}
			
//			int scoreDiff = winners.get(0).getScoreDiff();
//			int paiXingScore = calcPaiXing(winners.get(0));
			
			
//			if (!gameInfo.getWanfa().contains(ShanWeiWanFa.WF_NOFENGDIN) && paiXingScore>totalMax) {
//				
//				for(BasePlayer winner:gameInfo.getWinners()){
//					winner.setScoreDiff(0);
//					loser.setScoreDiff(0);
//				}
//				
//				for(BasePlayer winner:gameInfo.getWinners()){
//					
//					winner.setScore(winner.getScore()+totalMax);
//					loser.setScore(loser.getScore()-totalMax);
//					winner.setScoreDiff(winner.getScoreDiff()+totalMax);
//					loser.setScoreDiff(loser.getScoreDiff()-totalMax);
//				}
//			}
		}
		
		//流局
		if(winType==WINTYPE_FLOW){
			for(BasePlayer player:gameInfo.getPlayers()){
				player.getFans().clear();
				player.setResult(RESULT_BUREAU);
			}
		}
	}
	
	
	public int countJiangMa() {
		int jiangmaSize= 0;
		for (String s :gameInfo.getWanfa()) {
			if(s.startsWith(ShanWeiWanFa.WF_MATYPE_JIANGMA)){
				String substring1 = s.substring(ShanWeiWanFa.WF_MATYPE_JIANGMA.length());
				try {
					jiangmaSize=Integer.parseInt(substring1);
					log.debug("-=-=-=-=-=-=-=-=----=奖马："+jiangmaSize);
					
				} catch (Exception e) {
					jiangmaSize= 0;
					log.debug("=-=-=-=-=-=-=奖马为0");
				}
			}
			
		}
		return jiangmaSize;
		
	}
	
	public int countMaiMa() {
		int maimaSize= 0;
		for (String s : gameInfo.getWanfa()) {
			if(s.startsWith(ShanWeiWanFa.WF_MATYPE_MAIMA)){
				String substring2 = s.substring(ShanWeiWanFa.WF_MATYPE_MAIMA.length());
				try {
					maimaSize=Integer.parseInt(substring2);
					log.debug("--=-=-=-=-=-=-=-=-=-=买马："+maimaSize);
					
				} catch (Exception e) {
					maimaSize = 0;
					log.debug("-=-=-=-=-=-=买马为0");
				}
			}
		}
		return maimaSize;
	}
	
	
	private int calcJiangMa(BasePlayer winner) {
		int total=0;
		if(countJiangMa()>0) {	
			List<Byte> maCards = this.getJiangMaMaCards(winner);//中的马
			((ShanWeiPlayer)winner).getShowjiangMaCards().addAll(maCards);
				
			if ((gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA)||gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA))&&winner.getFlowerCards().size()>=7 && ((ShanWeiPlayer)winner).isCanqihuahu()){
				maCards.clear();
			}
			//抢杠胡无奖马
			if (gameInfo.isLoopGang()&&gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIANGGANGH_WM)&&gameInfo.getWinners().size()==1) {
				maCards.clear();
			}
			//一炮多响不算马
			if (gameInfo.getWinners().size()>1) {
				maCards.clear();
			}
			total=maCards.size()*this.calcPaiXing(winner);
			//抢杠胡包三家
			if (gameInfo.isLoopGang()) {
				total *= 3;
			}
			log.debug("==========================奖马的马钱："+total);
			
		}
		return total;
			
	}
	
	private void calJiangMa(BasePlayer winner,List<BasePlayer> losers) {
		
//		ShanWeiPlayer winner=(ShanWeiPlayer) gameInfo.getWinners().get(0);
//		List<BasePlayer> losers=new ArrayList<>(gameInfo.getPlayers());
		losers.remove(winner);
		int total=0;
//		int base=gameInfo.getBase();
		
//		if(gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MATYPE_JIANGMA)) {
		if(countJiangMa()>0) {	
			List<Byte> maCards = this.getJiangMaMaCards(winner);//中的马
			((ShanWeiPlayer)winner).getShowjiangMaCards().addAll(maCards);
				
			if ((gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA)||gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA))&&winner.getFlowerCards().size()>=7 && ((ShanWeiPlayer)winner).isCanqihuahu()){
				maCards.clear();
			}
			//抢杠胡无奖马
			if (gameInfo.isLoopGang()&&gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIANGGANGH_WM)&&gameInfo.getWinners().size()==1) {
				maCards.clear();
			}
			
			//一炮多响不算马
			if (gameInfo.getWinners().size()>1) {
				maCards.clear();
			}
			
			total=maCards.size()*this.calcPaiXing(winner);
			//抢杠胡包三家
			if (gameInfo.isLoopGang()) {
				total *= 3;
			}
			log.debug("==========================奖马的马钱："+total);
			
			for (BasePlayer loser:losers) {
				winner.setScore(winner.getScore()+total);
				loser.setScore(loser.getScore()-total);
				winner.setScoreDiff(winner.getScoreDiff()+total);
				loser.setScoreDiff(loser.getScoreDiff()-total);
			}
		}
		
	}
	
	//自己买的马牌中了几个自己的马牌
		public List<Byte> getMaiMaCards(BasePlayer player) {
			List<Byte> maCards = ((ShanWeiPlayer) player).getMaCards();// 玩家的马牌
			List<Byte> showMaCards = ((ShanWeiPlayer) player).getBuyMaCards();// 买的马牌
			List<Byte> maiMaCards = new ArrayList<>();// 中的马牌
			for (Byte card : showMaCards) {
				if (maCards.contains(card)) {
					maiMaCards.add(card);
				}
			}
			return maiMaCards;
		}
	
	/**
	 * 统计奖马中马数
	 * @param player
	 * @return
	 */
	public int jiangMaCount(BasePlayer player){
		int ma = 0;
		List<Byte> chosedMaCards = getJiangMaMaCards(player);
		ma = chosedMaCards.size();
		return ma;
	}
	
	/**
	 * 统计买马中马数
	 * @param player
	 * @return
	 */
	public int maiMaCount(BasePlayer player) {
		int ma = 0;
		List<Byte> chosedMaCards = getMaiMaMaCards(player);
		ma = chosedMaCards.size();
		return ma;
	}
	
	/**
	 * 统计买马马钱
	 * @param winner
	 * @param losers
	 */
	private void calMaiMa(BasePlayer winner,List<BasePlayer> losers) {
		//买马马钱
		losers.remove(winner);
//		if(gameInfo.getWanfa().contains(ShanWeiWanFa.WF_MATYPE_MAIMA)){
		if(countMaiMa()>0) {
			List<Byte> maCards = this.getMaiMaMaCards(winner);//赢家中的 马牌
			((ShanWeiPlayer)winner).getShowmaiMaCards().addAll(maCards);
			
			int total=0;
			boolean isMaiMa = true;
			int base=gameInfo.getBase();
//			total=2*maCards.size()*base;
//			for (BasePlayer loser:losers) {
//				winner.setScore(winner.getScore()+total);
//				loser.setScore(loser.getScore()-total);
//				winner.setScoreDiff(winner.getScoreDiff()+total);
//				loser.setScoreDiff(loser.getScoreDiff()-total);
//			}
			
//			List<Byte> maCards = this.getMaiMaMaCards(winner);//中的马
			((ShanWeiPlayer)winner).getShowmaiMaCards().addAll(maCards);
				
			if ((gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA)||gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA))&&winner.getFlowerCards().size()>=7 && ((ShanWeiPlayer)winner).isCanqihuahu()){
				maCards.clear();
				isMaiMa = false;
			}
			//抢杠胡无马
			if (gameInfo.isLoopGang()) {
				maCards.clear();
				isMaiMa = false;
			}
			//一炮多响不算马
			if (gameInfo.getWinners().size()>1) {
				maCards.clear();
				isMaiMa = false;
			}
			
//			int masize = maCards.size()>0?maCards.size():1;
			total=4*maCards.size()*base;
			for (BasePlayer loser:losers) {
				winner.setScore(winner.getScore()+total);
				loser.setScore(loser.getScore()-total);
				winner.setScoreDiff(winner.getScoreDiff()+total);
				loser.setScoreDiff(loser.getScoreDiff()-total);
			}
			
			if (isMaiMa) {
				// 输家买马结算  首先看翻出几个胡家的马，有几个胡家的马那么其他两个输家就要分别给这个人几份钱。
				for (BasePlayer tmpWin : losers) {
					List<BasePlayer> tmpLosers = new ArrayList<>(losers);
					List<Byte> maiMaMaCards = this.getMaiMaCards(tmpWin, winner);//当前输家的中的赢家马数
					//((ShanWeiPlayer) tmpWin).setBuyMaCards(maiMaMaCards);
					tmpLosers.remove(tmpWin);
					//中胡马牌
					if (maiMaMaCards.size() > 0) {
						for (BasePlayer tmpLoser : tmpLosers) {
							int t = 0;
							t = 4*maiMaMaCards.size()*base;
							tmpWin.setScore(tmpWin.getScore() + t);
							tmpLoser.setScore(tmpLoser.getScore() - t);
							tmpWin.setScoreDiff(tmpWin.getScoreDiff() + t);
							tmpLoser.setScoreDiff(tmpLoser.getScoreDiff() - t);
							log.debug("==============输家:"+tmpWin.getUserId()+"赢买马钱："+t);
						   }
						}
					if (gameInfo.getPlayers().size()>3) {
						//不中马牌
						int notzhongmacardsize = ((ShanWeiPlayer) tmpWin).getBuyMaCards().size() - maiMaMaCards.size();
						if (notzhongmacardsize > 0) {
							int t = 0; 
							t = notzhongmacardsize * base*4;
							winner.setScore(winner.getScore() + t);
							tmpWin.setScore(tmpWin.getScore() - t);
							winner.setScoreDiff(winner.getScoreDiff() + t);
							tmpWin.setScoreDiff(tmpWin.getScoreDiff() - t);
						}
					}else {
						if (losers.size()<=2) {
							tmpLosers.add(tmpWin);
						}
						
						for (BasePlayer tmpLoser : tmpLosers) {
							List<Byte> maiMaMaCards2 = this.getMaiMaCards(tmpWin, tmpLoser);//当前输家的中的其他输家马数
							int t = 0; 
							t = maiMaMaCards2.size() * base*4;
							winner.setScore(winner.getScore() + t);
							tmpWin.setScore(tmpWin.getScore() - t);
							winner.setScoreDiff(winner.getScoreDiff() + t);
							tmpWin.setScoreDiff(tmpWin.getScoreDiff() - t);
						}
					}
					
					
					if (gameInfo.getPlayers().size()==3) {
//						((ShanWeiPlayer) tmpWin).getBuyMaCards()
					}
					
				}
			}		
		}
	}
	
	private void calMaiMa(List<BasePlayer> winners,BasePlayer loser) {
		
		boolean isMaiMa = true;
//		if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA)||gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA)){
		if ((gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA)||gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA))&&winners.get(0).getFlowerCards().size()>=7 && ((ShanWeiPlayer)winners.get(0)).isCanqihuahu()){
//			maCards.clear();
			isMaiMa  = false;
		}
		//抢杠胡无马
		if (gameInfo.isLoopGang()) {
			isMaiMa = false;
		}
		//一炮多响不算马
		if (gameInfo.getWinners().size()>1) {
			isMaiMa = false;
		}
		
		
		int base = gameInfo.getBase();
		log.debug("+++++++++++++算买马");
		int ismaimashu=((ShanWeiPlayer) loser).getBuyMaCards().size();

		int ismaimayin=((ShanWeiPlayer) winners.get(0)).getBuyMaCards().size();
		
		if (isMaiMa) {
			List<Byte> maiMaCards2 = this.getMaiMaCards(loser);//获取输家中输家的马牌
			((ShanWeiPlayer) loser).getShowmaiMaCards().addAll(maiMaCards2);
			
			for (BasePlayer win : winners) {
				int total = 0;
				
				total = 4*maiMaCards2.size() * base;
				if(ismaimayin>0&&ismaimashu>0){//点炮者买马,胡牌者都买马的情况下
					win.setScore(win.getScore() + total);
					loser.setScore(loser.getScore() - total);
					win.setScoreDiff(win.getScoreDiff() + total);
					loser.setScoreDiff(loser.getScoreDiff() - total);
				}
			}
			
			//2.胡牌者买马：只看胡牌者的马，有几个胡牌者的马，点炮者就要给胡牌者几份买马的钱。
			for (BasePlayer win : winners) {
				List<Byte> maimaCards = this.getMaiMaCards(win);
				//((ShanWeiPlayer) winner).getBuyMaCards().addAll(maimaCards);
				((ShanWeiPlayer) win).getShowmaiMaCards().addAll(maimaCards);
				int total = 0;
				
				total = 4*maimaCards.size() * base;
				if(ismaimashu>0){
					win.setScore(win.getScore() + total);
					loser.setScore(loser.getScore() - total);
					win.setScoreDiff(win.getScoreDiff() + total);
					loser.setScoreDiff(loser.getScoreDiff() - total);
				}
			}	
			
			//3/其他玩家买马：看翻出来的马牌，胡牌者的马和点炮者的马之间的差，
			//如果胡牌者的马多，多几个，点炮者就要给买马者几个买马的钱；
			//如果是点炮者的马多，那么多几个，买马者就要给胡牌者几个买马的钱。
			// 先获取 平局的人 
			List<BasePlayer> drawers = new ArrayList<>(gameInfo.getPlayers());
			drawers.remove(loser);
			for (BasePlayer win : winners) {
				drawers.remove(win);
			}
			//drawers是没胡没点炮的人
			BasePlayer winner = winners.get(0);
			List<Byte> maimaCards = this.getMaiMaCards(winner);
			//((ShanWeiPlayer) winner).getBuyMaCards().addAll(maimaCards);
			((ShanWeiPlayer) winner).getShowmaiMaCards().addAll(maimaCards);
//		int base = 0;
			
			//平者买马牌中胡牌者的马和点炮者的马之间的差
			for (BasePlayer draw : drawers) {
				int ismaimaping=((ShanWeiPlayer) draw).getBuyMaCards().size();
				if(ismaimaping>0){//平者有买马
					int chazhi=this.getMaiMaCards(draw, loser).size()-this.getMaiMaCards(draw, winner).size();
					log.debug("差值："+draw.getUserId()+":"+chazhi);
					if(chazhi>0){//点炮人中的多
						int total=4*chazhi*base;
						winner.setScore(winner.getScore() + total);
						draw.setScore(draw.getScore() - total);
						winner.setScoreDiff(winner.getScoreDiff() + total);
						draw.setScoreDiff(draw.getScoreDiff() - total);
					}
					if(chazhi <0){
						int total=Math.abs(chazhi)*base*4;
						draw.setScore(draw.getScore() + total);
						loser.setScore(loser.getScore() - total);
						draw.setScoreDiff(draw.getScoreDiff() + total);
						loser.setScoreDiff(loser.getScoreDiff() - total);
					}
					if(chazhi ==0){
						int total=this.getMaiMaCards(draw, winner).size()*base*4;
						winner.setScore(winner.getScore() + total);
//						draw.setScore(draw.getScore() - total);
						winner.setScoreDiff(winner.getScoreDiff() + total);
//						draw.setScoreDiff(draw.getScoreDiff() - total);
						
//						draw.setScore(draw.getScore() + total);
						loser.setScore(loser.getScore() - total);
//						draw.setScoreDiff(draw.getScoreDiff() + total);
						loser.setScoreDiff(loser.getScoreDiff() - total);
						
					}
				}
			}
			
		}
		//点炮者，点炮者买马：只看点炮人的马有几个点炮者的马，点炮者就要给胡牌者几份马钱。
		
		log.debug("+++++++++++++=一炮一响买马");
	}
	
	/**
	 * 统计
	 * @param winner
	 * @param loser
	 */
	private void calc(BasePlayer winner, BasePlayer loser) {
		
		ShanWeiGameInfo swg = (ShanWeiGameInfo)gameInfo;
		int baseCash=swg.getBase();
		boolean hdljia2 = ((ShanWeiPlayer) winner).isHdljia2();
		
//		boolean isBanker=gameInfo.getBanker().equals(winner) || gameInfo.getBanker().equals(loser);
		
		/**  --  花   --**/
		int flowerFan = calcFlower(winner);
		/**  --  字   --**/
		int ziFan = calcZi(winner);
		
		int fan=0;//番的总数
		List<Fan> fans = winner.getFans();
		for (Fan f : fans) {
			fan+=f.getFan();
		}
		
//		fan += winnerflowerFan;
//		fan += ziFan; 
		
		//番*底 如果番为0 则为底数
		//fan = fan==0?((ShanWeiGameInfo)gameInfo).getBase() :baseCash;
//		int total=hdlfb?(fan+winnerflowerFan+ziFan)*baseCash*2:(fan+winnerflowerFan+ziFan)*baseCash;
		log.debug("+=-=-=-=-=====-=-=-=-番型有"+winner.getFans());
		for (Fan fan2 : fans) {
			if (fan2.getFanName().equals("七花")) {
				//如果胡牌胡七花,不再计算花的番
				flowerFan = 0;
			}
		}
		
		if (flowerFan>0) {
			fan += flowerFan;
//			winner.getFans().add(new Fan("花", flowerFan));
		}
		if (ziFan>0) {
			fan += ziFan;
//			winner.getFans().add(new Fan("字", ziFan));
		}
//		if (hdljia2) {
//			fan += 2;
//		}
		
		int total = fan*2*baseCash;
		if (gameInfo.isLoopGang()) {
			total *= 3;
		}
		
		winner.setScore(winner.getScore()+total);
		loser.setScore(loser.getScore()-total);
		winner.setScoreDiff(winner.getScoreDiff()+total);
		loser.setScoreDiff(loser.getScoreDiff()-total);

	}
	
	
//	private boolean isZhengHua(BasePlayer player,Byte card) {
//		return this.getZhengHuaMards(player).contains(card);
//	}
//	
//	private boolean isZhengZi(BasePlayer player,Byte card) {
//		return this.getZhengZiMards(player).contains(card);
//	}
	
	/**
	 * 牌型分结算
	 * @param player
	 * @return
	 */
	private int calcPaiXing(BasePlayer player) {
		
		//int base = 1;
		int scoreSum = 0;
		ShanWeiGameInfo swg = (ShanWeiGameInfo)gameInfo;
		int baseCash=swg.getBase();
//		boolean hdlfb = ((ShanWeiPlayer) player).isHdljia2();
		
//		boolean isBanker=gameInfo.getBanker().equals(winner) || gameInfo.getBanker().equals(loser);
		
		/**  --  花   --**/
		int flowerFan = calcFlower(player);
		/**  --  字   --**/
		int ziFan = calcZi(player);
		
		int fan=0;//番的总数
		List<Fan> fans = player.getFans();
		for (Fan f : fans) {
			fan+=f.getFan();
		}
		for (Fan fan2 : fans) {
			if (fan2.getFanName().equals("七花")) {
				//如果胡牌胡七花,不再计算花的番
				flowerFan = 0;
			}
			if (fan2.getFanName().equals("直杠")) {
				fan -= fan2.getFan();
			}
			if (fan2.getFanName().equals("补杠")) {
				fan -= fan2.getFan();
			}
			if (fan2.getFanName().equals("暗杠")) {
				fan -= fan2.getFan();
			}
		}
		fan += flowerFan;
		fan += ziFan;
		
		scoreSum = baseCash*fan*2;
		
		return scoreSum;
		
	}
	
	private void calcAll(BasePlayer winner, BasePlayer loser) {
		
//		int base = 1;
		ShanWeiGameInfo swg = (ShanWeiGameInfo)gameInfo;
		int baseCash=swg.getBase();
		boolean hdljia2 = ((ShanWeiPlayer) winner).isHdljia2();
		
//		boolean isBanker=gameInfo.getBanker().equals(winner) || gameInfo.getBanker().equals(loser);
		
		/**  --  花   --**/
		int flowerFan = calcFlower(winner);
		/**  --  字   --**/
		int ziFan = calcZi(winner);
		
		int fan=0;//番的总数
		List<Fan> fans = winner.getFans();
		for (Fan f : fans) {
			fan+=f.getFan();
		}
		
		for (Fan fan2 : fans) {
			if (fan2.getFanName().equals("七花")) {
				//如果胡牌胡七花,不再计算花的番
				flowerFan = 0;
			}
		}
		
		if (flowerFan>0) {
			fan += flowerFan;
//			winner.getFans().add(new Fan("花", flowerFan));
		}
		if (ziFan>0) {
			fan += ziFan;
//			winner.getFans().add(new Fan("字", ziFan));
		}
//		if (hdljia2) {
//			fan+=2;
//		}
		//boolean bankerFlag = gameInfo.getBanker().equals(winner);
		int total =0;
		
		//抢杠胡包三家 一炮多响包三家
		if (gameInfo.getWinners().size()>1 && !gameInfo.getWanfa().contains(ShanWeiWanFa.WF_YPDX_NOBSJ)) {
			total=fan*baseCash*6;
		}else {
			total=fan*baseCash*2;
		}
		
		
//		if (gameInfo.isLoopGang()&&gameInfo.getWinners().size()>2 && !gameInfo.getWanfa().contains(ShanWeiWanFa.WF_YPDX_NOBSJ)) {
////			total=hdlfb?fan*baseCash*2*2*3:fan*baseCash*2*3;
//			total=fan*baseCash*2*3;
//		}else if(gameInfo.isLoopGang()&&gameInfo.getWinners().size()>1 && !gameInfo.getWanfa().contains(ShanWeiWanFa.WF_YPDX_NOBSJ)) {
//			//抢杠胡包二家
//			total=fan*baseCash*2*2;
//		}else if(gameInfo.isLoopGang()&&gameInfo.getWinners().size()==1) {
//			//单人抢杠胡加一番
//			fan++;
//		}
//		total=fan*baseCash*2;
		winner.setScore(winner.getScore()+total);
		loser.setScore(loser.getScore()-total);
		winner.setScoreDiff(winner.getScoreDiff()+total);
		loser.setScoreDiff(loser.getScoreDiff()-total);

	}
	
	
	private void statistics(List<BasePlayer> winners, List<BasePlayer> losers, ShanWeiPlayer loser) {
		for (BasePlayer player : winners) {
			player.setResult(Consts.RESULT_WIN);
			player.setHuCount(player.getHuCount() + 1);
			if (gameInfo.getWintype() == WINTYPE_SELF_HU) {
				player.setZimoCount(player.getZimoCount() + 1);
				if (gameInfo.isGang()) {
					((ShanWeiPlayer) player).setGangKaiSum(((ShanWeiPlayer) player).getGangKaiSum()+1);
				}
			} else if (gameInfo.getWintype() == WINTYPE_HU || gameInfo.getWintype()==WINTYPE_LOOP_GANG) {
				loser.setDiaopaoCount(loser.getDiaopaoCount() + 1);
				if (gameInfo.isLoopGang()) {
					((ShanWeiPlayer) player).setQghcount(((ShanWeiPlayer) player).getQghcount()+1);
//					((ShanWeiPlayer) player).setBqghcount(((ShanWeiPlayer) player).getBqghcount()+1);
				}
//				((ShanWeiPlayer) player).setBqghcount(((ShanWeiPlayer) player).getBqghcount());
			}
		}
		for (BasePlayer player : losers) {
			player.setResult(Consts.RESULT_FAILED);
		}
//		for (BasePlayer player : gameInfo.getPlayers()) {
////			((ShanWeiPlayer) player).setZhigangcount(
////					((ShanWeiPlayer) player).getZhigangcount()+ ((ShanWeiPlayer) player).getZhigangcount());
////			((ShanWeiPlayer) player).setBugangcount((
////					((ShanWeiPlayer) player).getBugangcount() + ((ShanWeiPlayer) player).getBugangcount()));
////			((ShanWeiPlayer) player)
////					.setAnagangcount(((ShanWeiPlayer) player).getAnagangcount() + ((ShanWeiPlayer) player).getAnagangcount());
//			
//			if (gameInfo.isGang() && gameInfo.getWinners().contains(player)) {
//				((ShanWeiPlayer) player).setGangKaiSum(((ShanWeiPlayer) player).getGangKaiSum()+1);
//			}
//		}
	}
	

	/**
	 * 
	 * @param winners
	 * @param newArrayList
	 */
	private void statistics(List<BasePlayer> winners, List<BasePlayer> losers) {
		
//		int winType=gameInfo.getWintype();
//		ShanWeiGameInfo hzg = (ShanWeiGameInfo) gameInfo;
		for(BasePlayer player:winners){
		
			player.setResult(Consts.RESULT_WIN);
			player.setHuCount(player.getHuCount()+1);
			
			if(gameInfo.getWintype() == WINTYPE_SELF_HU){
				player.setZimoCount(player.getZimoCount()+1);
			}else if (gameInfo.getWintype() == WINTYPE_HU){
				losers.get(0).setDiaopaoCount(losers.get(0).getDiaopaoCount()+1);
			}
//			player.setFlowerCount(player.getFlowerCount()+calcHua(player));
			player.setFlowerCount(calcHua(player));
			
			if (gameInfo.isLoopGang()){
				ShanWeiPlayer winner = (ShanWeiPlayer)player;
				ShanWeiPlayer loser = (ShanWeiPlayer)losers.get(0);
				winner.setQghcount(winner.getQghcount()+1);
				loser.setBqghcount(loser.getQghcount()+1);
			}
			
		}
		for(BasePlayer player:losers){
			//if(winType==WINTYPE_HU) player.setDiaopaoCount(player.getDiaopaoCount()+1);
			player.setResult(Consts.RESULT_FAILED);
		}
		
	}
	
	/**
	 * 统计字的番数
	 * @param player
	 * @return
	 */
	private int calcZi(BasePlayer player) {
		
		int fan=0;//番的总数
		if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_ZHENGFUZI)) {
			//正字牌
			fan += 2*this.getZhengZiMards(player).size();
			//副字牌
			fan += (this.countZi(player)-this.getZhengZiMards(player).size());
		}
		
		if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_ZI_1FAN)) {
			fan+=this.countFeng(player);
			fan+=2*this.countJian(player);
		}
		
		if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_ZI_2FAN)) {
			fan+=2*this.countZi(player);
		}
		
		return fan;
	}
	
	public int countZi(BasePlayer player) {
		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(player.getCloseCards());
		if (gameInfo.getLastPlayCard()!=0) {
			cards.add(gameInfo.getLastPlayCard());
		}
		
		int countkezi=0;
		int countgang=0;
		for (Byte card : cards) {
			
			if(MjHelper.isZiPai(card)){
				if (this.countPai(player, card)==3) {
					countkezi++;
				}
				if (this.countPai(player, card)>=4) {
					countgang++;
				}
			}
		}
		log.debug("-=-=-=-=-=-=--=-=玩家"+player.getUserId()+"手中的牌，所有的字牌有***"+(countkezi/3+countgang/4)+"***张");
		return countkezi/3+countgang/4;
	}
	
	public int countFeng(BasePlayer player) {
		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(player.getCloseCards());
		if (gameInfo.getLastPlayCard()!=0) {
			cards.add(gameInfo.getLastPlayCard());
		}
		
		int countkezi=0;
		int countgang=0;
		for (Byte card : cards) {
			
			if(MjHelper.isFengPai(card)){
				if (this.countPai(player, card)==3) {
					countkezi++;
				}
				if (this.countPai(player, card)>=4) {
					countgang++;
				}
			}
		}
		log.debug("-=-=-=-=-=-=--=-=玩家"+player.getUserId()+"手中的牌，所有的风牌有***"+(countkezi/3+countgang/4)+"***张");
		return countkezi/3+countgang/4;
	}
	
	public int countJian(BasePlayer player) {
		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(player.getCloseCards());
		if (gameInfo.getLastPlayCard()!=0) {
			cards.add(gameInfo.getLastPlayCard());
		}
		
		int countkezi=0;
		int countgang=0;
		for (Byte card : cards) {
			
			if(MjHelper.isJianPai(card)){
				if (this.countPai(player, card)==3) {
					countkezi++;
				}
				if (this.countPai(player, card)>=4) {
					countgang++;
				}
			}
		}
		log.debug("-=-=-=-=-=-=--=-=玩家"+player.getUserId()+"手中的牌，所有的贱牌有***"+(countkezi/3+countgang/4)+"***张");
		return countkezi/3+countgang/4;
	}
	
	
	public static int checkTotal(List<Byte> cards,Byte card){
		int rtn=0;
		for(Byte b:cards){
			if(b==card) rtn++;
		}
		return rtn;
	}
	
	/**
	 * 统计某一张牌在该玩家胡牌牌型中的个数
	 * @param player
	 * @param c
	 * @return
	 */
	public int countPai(BasePlayer player, Byte c) {
		
		int countzi=0;
		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(player.getCloseCards());
		if (gameInfo.getLastPlayCard()!=0) {
			cards.add(gameInfo.getLastPlayCard());
		}
		System.out.println("==================这是最后动作的牌："+gameInfo.getLastPlayCard());
		
//		cards.add(player.getDoorCard());
//		cards.addAll(player.getPlayCards());
		
		for (Byte card : cards) {
			if (card.equals(c)) {
				countzi++;
			}
		}
		
		log.debug("============ 玩家："+player.getUserId()+" 手中的牌："+c + "有： "+countzi+" 张 ==========");
		
		return countzi;
	}
	
	/**
	 * 统计花数
	 * @param player
	 * @return
	 * 
	 */
	private int calcHua(BasePlayer player) {
		int flower=0;
		//无花算一花
		if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_WUHUA_ONE) && player.getFlowerCards().size()==0) {
			flower += 1;
		}
		flower += player.getFlowerCards().size();
		
		return flower;

	}
	
	/**
	 * 统计花的的番数
	 * @param player
	 * @author YZ
	 * @return
	 */
	private int calcFlower(BasePlayer player) {
		
		int flower = this.calcHua(player);
		int fan=0;//花的番数
		if (flower>0) {
			
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_ZHENGFHUA)) {
				fan+=2*this.getZhengHuaMards(player).size();
				fan+=flower-getZhengHuaMards(player).size();
			}
			
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_HUA_1FAN)) {
				fan+=flower;
			}
			if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_HUA_2FAN)) {
				fan+=2*flower;
			}
			
//			if (player.getFlowerCount()>=7) {
//				//fan += 14;
//				if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_10FAN_WUMA)) {
//					fan += 10;
//				}
//				
//				if (gameInfo.getWanfa().contains(ShanWeiWanFa.WF_QIHUA_16FAN_WUMA)) {
//					fan += 16;
//				}
//			}
		}
		
		return fan;
	}
	
//	public boolean canYangMa(BasePlayer checkedPlayer){
//		List<OpenCard> openCards=checkedPlayer.getOpenCards();
//		List<Byte> closeCards=checkedPlayer.getCloseCards();
//		List<Byte> addGangCards=new ArrayList<>();
//		for(OpenCard openCard:openCards){
//			if(openCard.getOpenCardsType()==Consts.CARDTYPE_PENG){
//				if(closeCards.contains(openCard.getOpenCardsOrig())){
//					addGangCards.add(openCard.getOpenCards().get(0));
//				}
//			}
//		}
//		checkedPlayer.setAddGangCards(addGangCards);
//		return !addGangCards.isEmpty();
//	}
	
	public boolean canYangMa(BasePlayer checkedPlayer){
//		
//		boolean canClearGang = false;
////		canClearGang = checkedPlayer.getCloseCards().stream().filter(card->{return card==actionCard;}).count()==3;
////		long count = checkedPlayer.getCloseCards().stream().filter(c->{return c==actionCard;}).count();
//		long count = 0;
//		log.debug("===========上一次的Action是："+gameInfo.getLastAction());
//		List<OpenCard> openCards=checkedPlayer.getOpenCards();
//		List<Byte> closeCards=checkedPlayer.getCloseCards();
//		List<Byte> yangMaCards=new ArrayList<>();
//		for(OpenCard openCard:openCards){
//			//count = checkedPlayer.getCloseCards().stream().filter(c->{return c==openCard.getOpenCards().get(0);}).count();
//			Byte card = openCard.getOpenCards().get(0);
//			if (countPai(checkedPlayer, card)==4) {
//				
//			}
//			
//			if(openCard.getOpenCardsType()==Consts.CARDTYPE_PENG){
//				
//				if(closeCards.contains(openCard.getOpenCardsOrig())){
//					yangMaCards.add(openCard.getOpenCards().get(0));
//				}
//			}
//		}
//		((ShanWeiPlayer)checkedPlayer).setYangMaCards(yangMaCards);
////		checkedPlayer.setAddGangCards(yangMaCards);
//		return !yangMaCards.isEmpty();
		boolean flag = false;
		for(Byte card : checkedPlayer.getCloseCards()) {
			if (((ShanWeiPlayer)checkedPlayer).getNoFeeGangCards().contains(card)) {
				flag = true;
			}
		}
		
		return flag;
		
	}
	
//	@Override
//	public boolean canTing(BasePlayer checkedPlayer) {
//		 if (checkedPlayer.isTing())
//			   return false;
//			  checkedPlayer.getTingPatterns().clear();
//
//			  ComplexHu hu = ComplexHu.from(checkedPlayer.getCloseCards()).setLaiZi(Lists.emptyList())
//			    // .setLaiZiCanBeCards(canBeCards)
//			    .addHuStrategy(Hus.normalHuStrategy()).needCheckTing().startCheck();
//
//			  boolean canting = hu.canTing();
//			  if (!canting) {
//			   List<TingInfo> checkTing = MjHelper.checkTing19z(new ArrayList<>(checkedPlayer.getCloseCards()));
//			   for (TingInfo ti : checkTing) {
//			    boolean c = false;
//			    for (TingPattern tp : hu.getTingPatterns()) {
//			     if (tp.getPlayCard() == ti.getPlayForTingCard()) {
//			      c = true;
//			      tp.getPatterns().get(0).getLaiziToCard().addAll(ti.getTingCards());
//			      break;
//			     }
//			    }
//			    if (!c) {
//			     TingPattern tp = new TingPattern();
//			     tp.setPlayCard(ti.getPlayForTingCard());
//			     Pattern p = new Pattern(null);
//			     p.getLaiziToCard().addAll(ti.getTingCards());
//			     if (tp.getPatterns() == null) {
//			      LinkedList<Pattern> ps = new LinkedList<>();
//			      ps.add(p);
//			      tp.setPatterns(ps);
//			     } else {
//			      tp.getPatterns().add(p);
//			     }
//			     hu.getTingPatterns().add(tp);
//			    }
//			   }
//			   canting=hu.getTingPatterns().size()>0?true:false;
//			  }
//			  checkedPlayer.setTingPatterns(hu.getTingPatterns());
//			  return canting;
//	}
	
	/**
	 * 配牌
	 */
//	@Override
//	public void makeCard(String gameName) {
//		  //String duigangKey="dg",jiangmaKey="jm",luodingKey="ld";
//		  //System.out.println(gameInfo.getCards());
//		  if (GameConfig.isMjTestCard()) {
//		   try {
//		    String testCards = DSQPGameHelper.getTestMJCards(gameName);
//		    if (!Strings.isNullOrEmpty(testCards)) {
//		     //
//		     log.debug("测试牌字符串：" + testCards);
//		     List<Byte> cards=gameInfo.getCards();
//		     String[] bcs = testCards.split(",");
//		     String cardArr=null;
//		     
//		     cardArr=testCards;
//		     log.debug("测试牌 ："+Arrays.asList(cardArr));
//		     //最后加了个end操作  就是表示。。。配的所有牌
//		     if (cardArr != null) {
//		      String[] split = cardArr.split("\\$");
//		      bcs=split[0].split(",");
//		      String[] cardArr_ = new String[bcs.length ];
//		      for (int i = 0; i < bcs.length; i++) {
//		       cardArr_[i ] = bcs[i];
//		      }
//		      if(cardArr_[cardArr_.length-1].equals("end")){
//		       List<Byte> tmps=new ArrayList<>();
//		       for (int i = 0; i < cardArr_.length; i++) {
//		        if(i!=cardArr_.length-1){
//		         byte card = (Byte.parseByte(cardArr_[i]));
//		         tmps.add(card);
//		        }
//		       }
//		       gameInfo.setCards(tmps);
//		      }else{
//		       for (int i = 0; i < cardArr_.length; i++) {
//		        byte card = (Byte.parseByte(cardArr_[i]));
//		        int index = cards.lastIndexOf(card);
//		        byte card_ = cards.get(i);
//		        cards.set(index, card_);
//		        cards.set(i, card);
//		       }
//		       if(split.length>1){//有$  是从倒数配牌
//		        String[] split2 = split[1].split(",");
//		        //换个思路  把后面的相关牌先移除了 再添加我们配置的倒数牌 16$17 c_=16 idx=15
//		        Iterator<Byte> it = cards.iterator();
//		        int idx=0;
//		        List<String> tmps=Arrays.asList(split2);
//		        while(it.hasNext()){
//		         Byte next = it.next();
//		         if(idx>=cardArr_.length&&tmps.contains(next+"")){
//		          it.remove();
//		         }
//		         idx++;
//		        }
//		        
//		        for (int i = 0; i < split2.length; i++) {
//		         cards.add(Byte.parseByte(split2[i]));
//		        }
//		       }
//		      }
//		      
//		     }
//		    }
//		    //System.out.println(gameInfo.getCards());
//		   } catch (Exception e) {
//		    log.error(e);
//		   }
//		  }
//
//	}
	
	// 模拟测试
	public static void main(String[] args) {
		List<BasePlayer> players=new ArrayList<>();
		for(int i=0;i<4;i++){
			ShanWeiPlayer hyp=new ShanWeiPlayer();
			hyp.setUserId(i);
			List<OpenCard> ocs=new ArrayList<>();
			List<Byte> closecard=new ArrayList<>();
			if(i==0){
//					closecard.addAll(Lists.make(CARD_1WAN,CARD_2WAN,CARD_3WAN,CARD_2TIAO,CARD_2TIAO,CARD_3TIAO,CARD_3TIAO,CARD_3TIAO,CARD_BAI,CARD_BAI,CARD_BAI,CARD_1TONG,CARD_1TONG,CARD_1TONG));
				hyp.setCloseCards(closecard);
				hyp.setMaCards(Lists.make(CARD_1WAN,CARD_2TIAO,CARD_BAI,CARD_1TONG));
				hyp.setBuyMaCards(Lists.make(CARD_1WAN,CARD_2TIAO,CARD_BAI,CARD_1TONG));
				//有关杠的结算
				OpenCard oc1=new OpenCard(Lists.make(CARD_1WAN,CARD_1WAN,CARD_1WAN,CARD_1WAN), CARD_1WAN, CARDTYPE_ANGANG, 0);
				oc1.setOpenCardsType(CARDTYPE_ANGANG);
				ocs.add(oc1);
				
				
			}
			if(i==1){
//				OpenCard oc1=new OpenCard(Lists.make(CARD_2TIAO,CARD_2TIAO,CARD_2TIAO,CARD_2TIAO), CARD_2TIAO, CARDTYPE_ANGANG, 0);
//				ocs.add(oc1);
				
			}
			if(i==2){
//				OpenCard oc1=new OpenCard(Lists.make(CARD_1TONG,CARD_1TONG,CARD_1TONG,CARD_1TONG), CARD_1TONG, CARDTYPE_CLEARGANG, 3);
//				ocs.add(oc1);
				
			}
			if(i==3){
//				OpenCard oc1=new OpenCard(Lists.make(CARD_BAI,CARD_BAI,CARD_BAI,CARD_BAI), CARD_BAI, CARDTYPE_ANGANG, 0);
//				ocs.add(oc1);
				
			}
			hyp.setOpenCards(ocs);
			players.add(hyp);
		}

		
		ShanWeiGameInfo gif=new ShanWeiGameInfo();
		gif.setBase(8);
//			gif.setMaxBase(2);
//			gif.setMinBase(1);
		gif.setPlayers(players);
		gif.setMaCards(Lists.make(CARD_1WAN,CARD_1TONG));
//			gif.setWanfa(Lists.make(WANFA_HUTYPE_2));
		ShanWeiLogic lo=new ShanWeiLogic();
		lo.setGameInfo(gif);
		//lo.canHu();
		lo.canHu(gif.getBanker(), CARD_BAI);
		lo.settle();
		for (BasePlayer basePlayer : players) {
			System.out.println(basePlayer.getScoreDiff());
		}
	}	

}
