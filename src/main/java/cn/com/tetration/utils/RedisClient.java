package cn.com.tetration.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisException;
/**
 * redis 操作示例
 * @author huangtao
 * 
 */
public class RedisClient {
	private static ShardedJedisPool pool;
	//redis123!@#
	static{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxWaitMillis(10000);
		
		String ipAndPort = "121.42.150.31:6379";
		
		List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
		String[] addressArr = ipAndPort.split(";");
		for (String str : addressArr) {
			list.add(new JedisShardInfo(str.split(":")[0], Integer.parseInt(str
					.split(":")[1])));
		}
		pool = new ShardedJedisPool(config,list);
	}
	public static void main(String[] args) {
		RedisClient.set("ht", "mbbbbbbbbbb");//保存ht
		RedisClient.expire("ht", 10);//保存10s
		System.out.println(RedisClient.get("ht"));
	}
	
	private RedisClient (){
		
	}

	/**
	 * 关闭 Redis
	 */
	public static void destory() {
		pool.destroy();
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static long del(byte [] key) {
		ShardedJedis shardedJedis = null;
		long ret = 0l;
		try {
			shardedJedis = pool.getResource();
			ret = shardedJedis.del(key);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static long del(String key) {
		ShardedJedis shardedJedis = null;
		long ret = 0l;
		try {
			shardedJedis = pool.getResource();
			ret = shardedJedis.del(key);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return ret;
	}
	/**
	 * 
	 * @param key
	 * @param fields
	 * @return
	 */
	public static long hdel(String key,String... fields) {
		
		ShardedJedis shardedJedis = null;
		long ret = 0l;
		try {
			shardedJedis = pool.getResource();
			ret = shardedJedis.hdel(key, fields);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return ret;
	}
	
	/**
	 * redis的List集合 ，向key这个list添加元素
	 * 
	 * @param key
	 *            List别名
	 * @param string
	 *            元素
	 * @return
	 */
	public static long rpush(String key, String string) {
		ShardedJedis shardedJedis = null;
		long ret = 0l;
		try {
			shardedJedis = pool.getResource();
			ret = shardedJedis.rpush(key, string);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return ret;
	}

	/**
	 * redis的List集合 ，向key这个list添加多个元素
	 * 
	 * @param key
	 *            List别名
	 * @param string
	 *            元素
	 * @return
	 */
	public static long rpushx(String key, String... string) {
		ShardedJedis shardedJedis = null;
		long ret = 0l;
		try {
			shardedJedis = pool.getResource();
			ret = shardedJedis.rpushx(key, string);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return ret;
	}
	
	/**
	 * 获取key这个List，从第几个元素到第几个元素 LRANGE key start
	 * stop返回列表key中指定区间内的元素，区间以偏移量start和stop指定。
	 * 下标(index)参数start和stop都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。
	 * 也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。
	 * 
	 * @param key
	 *            List别名
	 * @param start
	 *            开始下标
	 * @param end
	 *            结束下标
	 * @return
	 */
	public static List<String> lrange(String key, long start, long end) {
		ShardedJedis shardedJedis = null;
		List<String> ret  = null;
		try {
			shardedJedis = pool.getResource();
			ret = shardedJedis.lrange(key, start, end);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return ret;
	}

	/**
	 * 将哈希表key中的域field的值设为value。
	 * 
	 * @param key
	 *            哈希表别名
	 * @param field键
	 * @param value
	 *            值
	 */
	public static void hset(String key, String field, String value) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.hset(key, field, value);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}

	/**
	 * 向key赋值
	 * 
	 * @param key
	 * @param value
	 */
	public static void set(String key, String value) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.set(key, value);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}
	
	/**
	 * 向key赋值
	 * @param key
	 * @param value
	 */
	public static void set(byte [] key, byte [] value) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.set(key, value);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}
	
	/**
	 * 获取key的值
	 * 
	 * @param key
	 * @return
	 */
	public static byte[] get(byte[] key) {
		ShardedJedis shardedJedis = null;
		byte[] value = null;
		try {
			shardedJedis = pool.getResource();
			value = shardedJedis.get(key);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return value;
	}

	/**
	 * 获取key的值
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		ShardedJedis shardedJedis = null;
		String value = null;
		try {
			shardedJedis = pool.getResource();
			value = shardedJedis.get(key);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return value;
	}

	/**
	 * 将多个field - value(域-值)对设置到哈希表key中。
	 * 
	 * @param key
	 * @param map
	 */
	public static void hmset(String key, Map<String, String> map) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.hmset(key, map);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}

	/**
	 * 给key赋值，并生命周期设置为seconds
	 * 
	 * @param key
	 * @param seconds
	 *            生命周期 秒为单位
	 * @param value
	 */
	public static void setex(String key, int seconds, String value) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.setex(key, seconds, value);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}
	
	/**
	 * 为给定key设置生命周期
	 * 
	 * @param key
	 * @param seconds
	 *            生命周期 秒为单位
	 */
	public static void expire(byte[] key, int seconds) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.expire(key, seconds);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}

	/**
	 * 为给定key设置生命周期
	 * 
	 * @param key
	 * @param seconds
	 *            生命周期 秒为单位
	 */
	public static void expire(String key, int seconds) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.expire(key, seconds);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}

	/**
	 * 检查key是否存在
	 * 
	 * @param key
	 * @return
	 */
	public static boolean exists(String key) {
		ShardedJedis shardedJedis = null;
		boolean bool = false;
		try {
			shardedJedis = pool.getResource();
			bool = shardedJedis.exists(key);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return bool;
	}

	/**
	 * 返回key值的类型 none(key不存在),string(字符串),list(列表),set(集合),zset(有序集),hash(哈希表)
	 * 
	 * @param key
	 * @return
	 */
	public static String type(String key) {
		ShardedJedis shardedJedis = null;
		String type =null;
		try {
			shardedJedis = pool.getResource();
			type = shardedJedis.type(key);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return type;
	}

	/**
	 * 从哈希表key中获取field的value
	 * 
	 * @param key
	 * @param field
	 */
	public static String hget(String key, String field) {
		ShardedJedis shardedJedis = null;
		String value =null;
		try {
			shardedJedis = pool.getResource();
			value = shardedJedis.hget(key, field);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return value;
	}

	/**
	 * 返回哈希表key中，所有的域和值
	 * 
	 * @param key
	 * @return
	 */
	public static Map<String, String> hgetAll(String key) {
		ShardedJedis shardedJedis = null;
		Map<String, String> map =null;
		try {
			shardedJedis = pool.getResource();
			map = shardedJedis.hgetAll(key);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return map;
	}

	/**
	 * 返回集合key中，所有的成员
	 * 
	 * @param key
	 * @return
	 */
	public static Set<?> smembers(String key) {
		ShardedJedis shardedJedis = null;
		Set<?> set =null;
		try {
			shardedJedis = pool.getResource();
			set = shardedJedis.smembers(key);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return set;
	}

	/**
	 * 移除集合中的member元素
	 * 
	 * @param key
	 *            List别名
	 * @param field
	 *            键
	 */
	public static void delSetObj(String key, String field) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.srem(key, field);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}

	/**
	 * 判断member元素是否是集合key的成员。是（true），否则（false）
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public static boolean isNotField(String key, String field) {
		ShardedJedis shardedJedis = null;
		boolean bool = false;
		try {
			shardedJedis = pool.getResource();
			bool = shardedJedis.sismember(key, field);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
		return bool;
	}

	/**
	 * 如果key已经存在并且是一个字符串，将value追加到key原来的值之后
	 * 
	 * @param key
	 * @param value
	 */
	public static void append(String key, String value) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = pool.getResource();
			shardedJedis.append(key, value);
		} catch (Exception e) {
			pool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			throw new JedisException(e);
		}finally{
			if (shardedJedis != null) { 
				pool.returnResource(shardedJedis);
			}
		}
	}
}
