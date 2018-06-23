-- ---------------------------
-- Table structure for characters
-- ---------------------------
CREATE TABLE IF NOT EXISTS characters (
  account_name varchar(45) default NULL,
  obj_Id decimal(11,0) NOT NULL default '0',
  char_name varchar(35) NOT NULL,
  `level` decimal(11,0) default NULL,
  maxHp decimal(11,0) default NULL,
  curHp decimal(18,0) default NULL,
  maxCp decimal(11,0) default NULL,
  curCp decimal(18,0) default NULL,
  maxMp decimal(11,0) default NULL,
  curMp decimal(18,0) default NULL,
  acc decimal(11,0) default NULL,
  crit decimal(10,0) default NULL,
  evasion decimal(11,0) default NULL,
  mAtk decimal(11,0) default NULL,
  mDef decimal(11,0) default NULL,
  mSpd decimal(11,0) default NULL,
  pAtk decimal(11,0) default NULL,
  pDef decimal(11,0) default NULL,
  pSpd decimal(11,0) default NULL,
  runSpd decimal(11,0) default NULL,
  walkSpd decimal(11,0) default NULL,
  str decimal(11,0) default NULL,
  con decimal(11,0) default NULL,
  dex decimal(11,0) default NULL,
  _int decimal(11,0) default NULL,
  men decimal(11,0) default NULL,
  wit decimal(11,0) default NULL,
  face decimal(11,0) default NULL,
  hairStyle decimal(11,0) default NULL,
  hairColor decimal(11,0) default NULL,
  sex decimal(11,0) default NULL,
  heading decimal(11,0) default NULL,
  x decimal(11,0) default NULL,
  y decimal(11,0) default NULL,
  z decimal(11,0) default NULL,
  movement_multiplier decimal(9,8) default NULL,
  attack_speed_multiplier decimal(10,9) default NULL,
  colRad decimal(10,3) default NULL,
  colHeight decimal(10,3) default NULL, 
  exp decimal(20,0) default NULL,
  expBeforeDeath decimal(20,0) default 0,
  sp decimal(11,0) default NULL,
  karma decimal(11,0) default NULL,
  pvpkills decimal(11,0) default NULL,
  pkkills decimal(11,0) default NULL,
  clanid decimal(11,0) default NULL,
  race decimal(11,0) default NULL,
  classid decimal(11,0) default NULL,
  base_class int(2) NOT NULL default '0',
  deletetime decimal(20,0) default NULL,
  cancraft decimal(11,0) default NULL,
  title varchar(16) default NULL,
  rec_have int(3) NOT NULL default '0',
  rec_left int(3) NOT NULL default '0',
  accesslevel decimal(4,0) default NULL,
  online decimal(1,0) default NULL,
  onlinetime decimal(20,0) default NULL,
  char_slot decimal(1) default NULL,
  lastAccess decimal(20,0) default NULL,
  clan_privs INT DEFAULT 0,
  wantspeace decimal(1,0) DEFAULT 0,
  isin7sdungeon decimal(1,0) NOT NULL default 0,
  in_jail decimal(1,0) DEFAULT 0,
  jail_timer decimal(20,0) DEFAULT 0,
  power_grade decimal(11,0) DEFAULT NULL,
  nobless decimal(1,0) NOT NULL DEFAULT 0,
  subpledge int(1) NOT NULL DEFAULT 0,
  last_recom_date decimal(20,0) NOT NULL DEFAULT 0,
  lvl_joined_academy int(1) NOT NULL DEFAULT 0,
  apprentice int(1) NOT NULL DEFAULT 0,
  sponsor int(1) NOT NULL DEFAULT 0,
  varka_ketra_ally int(1) NOT NULL DEFAULT 0,
  clan_join_expiry_time DECIMAL(20,0) NOT NULL DEFAULT 0,
  clan_create_expiry_time DECIMAL(20,0) NOT NULL DEFAULT 0,
  death_penalty_level int(2) NOT NULL DEFAULT 0,
  PRIMARY KEY  (obj_Id),
  KEY `clanid` (`clanid`)
) ;
