package golang_solutions

type OrgChart struct {
	Name          string
	DirectReports []*OrgChart
}

func GetLowestCommonManager(report, first, second *OrgChart) *OrgChart {
	// Write your code here.
	if report.Name == first.Name {
		return report
	}
	if report.Name == second.Name {
		return report
	}
	reports := make([]*OrgChart, 0)
	for _, r := range report.DirectReports {
		if temp := GetLowestCommonManager(r, first, second); temp != nil {
			reports = append(reports, temp)
		}
	}
	if len(reports) == 2 {
		return report
	}
	if len(reports) == 1 {
		return reports[0]
	}
	return nil
}
