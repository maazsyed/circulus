/*
Created by: Maaz Syed
Date: 4/13/2016 12:56am
*/
package net.projectGroup2.dao;

import net.projectGroup2.form.ViewPosts;
import net.projectGroup2.model.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Repository("viewpostsDAO")
public class ViewPostsDAOImpl implements ViewPostsDAO {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public List<Posts> viewPosts(String userName) {
		//System.out.println("In View posts "+search);
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String tagValue = null;
		// Query using Hibernate Query Language
		String SQL_QUERY = "from Posts p where user_name =? order by p.timestamp desc";

		
		System.out.println("In View posts...3");
		Query query = session.createQuery(SQL_QUERY);
		System.out.println("In View posts...4");
		query.setParameter(0, userName);
		System.out.println("In View posts...6");
		
		System.out.println("In View posts...7");
		List list = query.list();

		session.close();
		return list;
	}
	
	public List<Posts> viewPosts(String userName, String title, String search) {
		System.out.println("In View posts "+search);
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String tagValue = null;
		// Query using Hibernate Query Language
		String SQL_QUERY = null;
		
		if  (search.equalsIgnoreCase("tag")){
			tagValue = title;
			SQL_QUERY = "from Posts p where tags Like ? order by p.timestamp desc";
			title = "";
			System.out.println("In View posts "+tagValue);
		}
		
		if (!(userName.isEmpty())) {
			System.out.println("In View posts...2");
			if (search.equalsIgnoreCase("user")){
				SQL_QUERY = "from Posts p where user_name Like ? order by p.timestamp desc";
			} else if (!(title.isEmpty())){
				SQL_QUERY = "from Posts p where user_name =? and title =? order by p.timestamp desc";
			} else {
				SQL_QUERY = "from Posts p order by p.timestamp desc";
			}	
		} else if (!(title.isEmpty())){
			SQL_QUERY = "from Posts p where title Like ? order by p.timestamp desc";
		}
		
		System.out.println("In View posts...3");
		Query query = session.createQuery(SQL_QUERY);
		System.out.println("In View posts...4");
		if (!(userName.isEmpty())&&(!title.isEmpty())) {
			System.out.println("In View posts...5");
			if (search.equalsIgnoreCase("user")){
				query.setParameter(0, "%"+userName+"%");
			} else {
				query.setParameter(0, userName);
				System.out.println("In View posts...6");
				query.setParameter(1, title);
			}
		} else if (!(title.isEmpty())){
			System.out.println("In View posts...6");
			query.setParameter(0, "%"+title+"%");
		}
		
		if (search.equalsIgnoreCase("user")){
			query.setParameter(0, "%"+userName+"%");
		}
		
		if  (search.equalsIgnoreCase("tag")){
			query.setParameter(0, "%"+tagValue+"%");
		}
		
		System.out.println("In View posts...7");
		List list = query.list();
		System.out.println("In View posts...8" +search);

		if ((!(userName.isEmpty()) || title.isEmpty())&&(!(search.equalsIgnoreCase("user")||search.equalsIgnoreCase("tag")))) {
			String SQL_QUERY2 = "from Tags t where user_name =?";
			Query query2 = session.createQuery(SQL_QUERY2);
			query2.setParameter(0, userName);
			List list2 = query2.list();

			Iterator<Tags> tags = list2.iterator();
			Iterator<Posts> posts = list.iterator();
			int i = -1, size = list.size();
			Posts post;
			Tags tag;
			List<String> tagValues = new ArrayList<String>();
			List<Integer> removeIndex = new ArrayList<Integer>();

			do {
				tagValues.add(tags.next().getTag());
				// System.out.println(tags.next().getTag());
			} while (tags.hasNext());

			for (String temp : tagValues) {
				i = -1;
				do {
					// System.out.println(i+" temp: "+temp);
					i++;
					String[] tokens = posts.next().getTags().split(",");
					for (int i1 = 0; i1 < tokens.length; i1++)
						if (((tokens[i1]).equalsIgnoreCase(temp)) && (!(removeIndex.contains(i)))) {
							removeIndex.add(i);
							System.out.println(" temp: " + temp + " DEB: " + i);
						}
				} while (posts.hasNext());
				posts = list.iterator();
			}

			Iterator<Integer> hi2 = removeIndex.iterator();
			while (hi2.hasNext()) {
				// list.remove(hi2.next());
				System.out.println(hi2.next());
			}

			List<Integer> ri = new ArrayList<Integer>();
			for (int j = 0; j < size; j++) {
				if (!(removeIndex.contains(j))) {
					ri.add(j);
				}
			}

			System.out.println("DEBUG");

			int k = -1;
			Iterator<Integer> hi = ri.iterator();
			while (hi.hasNext()) {
				k++;
				list.remove((hi.next().intValue()) - k);
				// System.out.println((hi.next().intValue())-k);
			}
		}
		
		

		session.close();
		return list;
	}
	
	public List<Polls> viewPolls(String userName, String title, String search) {
		System.out.println("In View polls");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String tagValue = null;
		// Query using Hibernate Query Language
		String SQL_QUERY = null;
		
		if  (search.equalsIgnoreCase("tag")){
			tagValue = title;
			SQL_QUERY = "from Polls p where tag Like ? order by p.timestamp desc";
			title = "";
			System.out.println("In View polls "+tagValue);
		}
		
		/* if (title.isEmpty()) {
			System.out.println("In View posts...2");
			SQL_QUERY = "from Polls p order by p.timestamp desc";
		} else
			SQL_QUERY = "from Polls p where user_name =? and title =? order by p.timestamp desc"; */
		
		if (!(userName.isEmpty())) {
			System.out.println("In View polls...2");
			if (search.equalsIgnoreCase("user")){
				SQL_QUERY = "from Polls p where user_name Like ? order by p.timestamp desc";
			} else if (!(title.isEmpty())){
				SQL_QUERY = "from Polls p where user_name =? and title =? order by p.timestamp desc";
			} else {
				SQL_QUERY = "from Polls p order by p.timestamp desc";
			}	
		} else if (!(title.isEmpty())){
			SQL_QUERY = "from Polls p where title Like ? order by p.timestamp desc";
		}
		
		System.out.println("In View Polls...3");
		Query query = session.createQuery(SQL_QUERY);
		System.out.println("In View Polls...4");
		/* if (!(title.isEmpty())) {
			System.out.println("In View Polls...5");
			query.setParameter(0, userName);
			System.out.println("In View Polls...6");
			query.setParameter(1, title);
		} */
		
		if (!(userName.isEmpty())&&(!title.isEmpty())) {
			System.out.println("In View Polls...5");
			if (search.equalsIgnoreCase("user")){
				query.setParameter(0, "%"+userName+"%");
			} else {
				query.setParameter(0, userName);
				System.out.println("In View Polls...6");
				query.setParameter(1, title);
			}
		} else if (!(title.isEmpty())){
			System.out.println("In View Polls...6");
			query.setParameter(0, "%"+title+"%");
		}
		
		if (search.equalsIgnoreCase("user")){
			query.setParameter(0, "%"+userName+"%");
		}
		
		if  (search.equalsIgnoreCase("tag")){
			query.setParameter(0, "%"+tagValue+"%");
		}
		
		System.out.println("In View posts...7");
		List list = query.list();
		System.out.println("In View posts...8");

		//if (title.isEmpty()) {
		if ((!(userName.isEmpty()) || title.isEmpty())&&(!(search.equalsIgnoreCase("user")||search.equalsIgnoreCase("tag")))) {
			String SQL_QUERY2 = "from Tags t where user_name =?";
			Query query2 = session.createQuery(SQL_QUERY2);
			query2.setParameter(0, userName);
			List list2 = query2.list();

			Iterator<Tags> tags = list2.iterator();
			Iterator<Polls> posts = list.iterator();
			int i = -1, size = list.size();
			Posts post;
			Tags tag;
			List<String> tagValues = new ArrayList<String>();
			List<Integer> removeIndex = new ArrayList<Integer>();

			while (tags.hasNext()) {
				tagValues.add(tags.next().getTag());
				// System.out.println(tags.next().getTag());
			} 

			for (String temp : tagValues) {
				i = -1;
				do {
					// System.out.println(i+" temp: "+temp);
					i++;
					String[] tokens = posts.next().getTags().split(",");
					for (int i1 = 0; i1 < tokens.length; i1++)
						if (((tokens[i1]).equalsIgnoreCase(temp)) && (!(removeIndex.contains(i)))) {
							removeIndex.add(i);
							System.out.println(" temp: " + temp + " DEB: " + i);
						}
				} while (posts.hasNext());
				posts = list.iterator();
			}

			Iterator<Integer> hi2 = removeIndex.iterator();
			while (hi2.hasNext()) {
				// list.remove(hi2.next());
				System.out.println(hi2.next());
			}

			List<Integer> ri = new ArrayList<Integer>();
			for (int j = 0; j < size; j++) {
				if (!(removeIndex.contains(j))) {
					ri.add(j);
				}
			}

			System.out.println("DEBUG");

			int k = -1;
			Iterator<Integer> hi = ri.iterator();
			while (hi.hasNext()) {
				k++;
				list.remove((hi.next().intValue()) - k);
				// System.out.println((hi.next().intValue())-k);
			}
		}

		session.close();
		return list;
	}

	public List<Posts> viewTrends() {
		System.out.println("In View TREND!!!");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		// Query using Hibernate Query Language
		
		java.util.Date date = new java.util.Date();
		System.out.println(new Timestamp(date.getTime()));
		Timestamp ti = new Timestamp(date.getTime());
		
		String SQL_QUERY = "from Posts p order by p.timestamp desc";
		Query query = session.createQuery(SQL_QUERY);
		// query.setParameter(0,userName);
		query.setMaxResults(5);
		List list = query.list();

		List<Integer> postIds = new ArrayList<Integer>();
		Iterator<Posts> post = list.iterator();
		do {
			postIds.add(post.next().getId().intValue());
			// System.out.println(tags.next().getTag());
		} while (post.hasNext());

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println(timeStamp);

		SQL_QUERY = "select distinct p.post_id from Votes p";
		query = session.createQuery(SQL_QUERY);
		List list4 = query.list();

		SQL_QUERY = "select distinct p.post_id from Comments p";
		query = session.createQuery(SQL_QUERY);
		List list3 = query.list();

		list3.removeAll(list4);
		list3.addAll(list4);

		Iterator<Long> ids = list3.iterator();
		Iterator<Integer> count;
		List<String> hm = new ArrayList();
		List<Long> hm2 = new ArrayList();
		Long idss;
		Long counts = (long) 0;
		Long votes = (long) 0;
		Long voco = (long) 0;
		do {
			SQL_QUERY = "select count(p.post_id) from Comments p where p.post_id =? group by p.post_id ";
			query = session.createQuery(SQL_QUERY);
			idss = ids.next();
			query.setParameter(0, idss);

			List list2 = query.list();
			if (!(list2.isEmpty())) {
				counts = (Long) list2.iterator().next();
				voco = counts;
			}

			SQL_QUERY = "select count(p.post_id) from Votes p where p.post_id =? group by p.post_id ";
			query = session.createQuery(SQL_QUERY);
			query.setParameter(0, idss);

			List list1 = query.list();
			if (!(list1.isEmpty())) {
				votes = (Long) list1.iterator().next();
				voco += votes;
			}

			System.out.println(voco);
			String voc = String.format("%09d", voco);
			hm.add(voc + " " + idss);
			// hm2.add(counts+votes);

		} while (ids.hasNext());

		Collections.sort(hm);
		Collections.reverse(hm);
		Iterator<String> h = hm.iterator();
		do {
			System.out.println(h.next());
		} while (h.hasNext());

		h = hm.iterator();
		Long index = (long) 0;
		String[] ind;
		List tempList, finalList = null;
		list.removeAll(list);
		do {
			ind = h.next().split(" ");
			index = Long.parseLong(ind[1]);
			System.out.println(index);

			SQL_QUERY = "from Posts p where p.id =?";
			query = session.createQuery(SQL_QUERY);
			query.setParameter(0, index);
			// query.setMaxResults(5);
			tempList = query.list();
			list.add(tempList.get(0));

		} while (h.hasNext());

		// int size = list.size();
		// list.add(list.get(0));
		
		/*Iterator<Posts> po = list.iterator();
		while(po.hasNext()){
			Posts pos = po.next();
			System. pos.getTimestamp();
		}*/
		
		session.close();
		return list;
	}
}