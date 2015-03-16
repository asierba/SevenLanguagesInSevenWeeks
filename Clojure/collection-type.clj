(defn collection-type [col] 
	(if (instance? clojure.lang.PersistentVector col) 
		:vector 
		(if (instance? clojure.lang.PersistentList col) 
			:list 
			(if (instance? clojure.lang.IPersistentMap col) 
				:map
				:unknown
			)
		)		
	)
)