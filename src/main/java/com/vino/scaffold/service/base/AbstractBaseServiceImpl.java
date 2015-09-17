package com.vino.scaffold.service.base;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vino.scaffold.entity.base.BaseEntity;
import com.vino.scaffold.repository.base.BaseRepository;
@Transactional
public abstract class AbstractBaseServiceImpl<T extends BaseEntity<PK>,PK extends Serializable> {
	@Autowired
	protected BaseRepository<T, PK> baseRepository;//������ע��
	public List<T> findAll(){
		return baseRepository.findAll();
	}
	public T findOne(PK id){
		return baseRepository.findOne(id);
	}
	public void save(T obj){
		baseRepository.save(obj);
	}
	public void save(List<T> objs){
		baseRepository.save(objs);
	}
	@SuppressWarnings("unchecked")
	public void delete(PK ...ids){
		for(PK id:ids)
		baseRepository.delete(id);
		
	}
	public void deleteAll(){
		baseRepository.deleteAll();		
	}
	public long getCount(){
		return baseRepository.count();
	}
	public Page<T> findAll(Pageable pageable){
		return baseRepository.findAll(pageable);
	}
	public BaseRepository<T, PK> getBaseRepository() {
		return baseRepository;
	}
	public void setBaseRepository(BaseRepository<T, PK> baseRepository) {
		this.baseRepository = baseRepository;
	}
	
}
