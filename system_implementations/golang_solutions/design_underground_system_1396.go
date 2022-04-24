package golang_solutions

type timeKeeper struct {
	stationName string
	time        int
}

type UndergroundSystem struct {
	stationTimeInfo map[string]map[string][]int
	timeFollower    map[int]*timeKeeper
}

func ConstructorUndergroundSystem() UndergroundSystem {
	return UndergroundSystem{
		stationTimeInfo: make(map[string]map[string][]int),
		timeFollower:    make(map[int]*timeKeeper),
	}
}

func (this *UndergroundSystem) CheckIn(id int, stationName string, t int) {
	this.timeFollower[id] = &timeKeeper{stationName: stationName, time: t}
	if _, ok := this.stationTimeInfo[stationName]; !ok {
		this.stationTimeInfo[stationName] = make(map[string][]int)
	}
}

func (this *UndergroundSystem) CheckOut(id int, stationName string, t int) {
	currentTimeKeeper := this.timeFollower[id]
	timeToTravel := t - currentTimeKeeper.time
	stationInfo := this.stationTimeInfo[currentTimeKeeper.stationName]
	if val, ok := stationInfo[stationName]; ok {
		this.stationTimeInfo[currentTimeKeeper.stationName][stationName] = append(val, timeToTravel)
	} else {
		this.stationTimeInfo[currentTimeKeeper.stationName][stationName] = append(make([]int, 0), timeToTravel)
	}
}

func (this *UndergroundSystem) GetAverageTime(startStation string, endStation string) float64 {
	allTimeTravel := this.stationTimeInfo[startStation][endStation]
	sum := 0
	for _, v := range allTimeTravel {
		sum += v
	}
	return float64(sum) / float64(len(allTimeTravel))
}
