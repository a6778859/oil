package com.oil.upms.client.session;

import com.oil.common.util.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class RedisSessionDao extends AbstractSessionDAO {
    private final static String OIL_UPMS_SHIRO_SESSION_ID = "oil-upms-shiro-session-id";


    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        RedisUtil.set(OIL_UPMS_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String session = RedisUtil.get(OIL_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
        return SerializableUtil.deserialize(session);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        // 如果会话过期/停止 没必要再更新了
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return;
        }
        RedisUtil.set(OIL_UPMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        // 更新ZHENG_UPMS_SERVER_SESSION_ID、ZHENG_UPMS_SERVER_CODE过期时间 TODO
    }

    @Override
    public void delete(Session session) {
        String sessionId = session.getId().toString();
        RedisUtil.remove(OIL_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
    }

    @Override
    public Collection<Session> getActiveSessions() {
//        Set<Session> sessions = new HashSet<>();
//
//        Set<String> keys = RedisUtil.ge(OIL_UPMS_SHIRO_SESSION_ID + "*");
//        if (keys != null && keys.size() > 0) {
//            for (String key : keys) {
//                Session s = (Session) SerializableUtil.deserialize(RedisUtil.get(key));
//                sessions.add(s);
//            }
//        }
//        return sessions;
        return null;
    }
}
