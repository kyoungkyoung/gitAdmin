package chart.service;

import java.util.List;

import chart.bean.EtcDTO;
import chart.bean.MemChartDTO;
import community.bean.CommunityDTO;

public interface ChartService {

	public List<EtcDTO> getEtc(String seq);

	public List<EtcDTO> getDate(String seq, String date);

	public CommunityDTO getCommunityDTO(int seq);

	public List<MemChartDTO> getMemData(String date);

	public List<CommunityDTO> getTestHit();

	public List<CommunityDTO> getloveHit();
}
