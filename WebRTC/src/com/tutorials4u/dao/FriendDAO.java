package com.tutorials4u.dao;
import java.util.List;

import com.tutorials4u.domain.Friend;


public interface FriendDAO {
	public void saveFriend(Friend friend);
	public List<Friend> listFriend();
}
