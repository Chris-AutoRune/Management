package io.autorune.updater.analyzer.classes.implementations.world

import io.autorune.updater.analyzer.classes.ClassAnalyzer
import io.autorune.updater.analyzer.classes.annotations.CorrectFieldCount
import io.autorune.updater.analyzer.classes.annotations.CorrectMethodCount
import io.autorune.updater.analyzer.classes.annotations.DependsOn
import org.objectweb.asm.tree.ClassNode

@CorrectFieldCount(0)
@CorrectMethodCount(0)
@DependsOn(WorldMapArea::class)
class WorldMapAreaData : ClassAnalyzer() {

    override fun findClassNode(): ClassNode? {
        for (classNode in classPool) {

            if (classNode.superName != getClassAnalyser(WorldMapArea::class)?.classNode?.name)
                continue

            return classNode

        }

        return null
    }

    override fun getFields() {

    }


}